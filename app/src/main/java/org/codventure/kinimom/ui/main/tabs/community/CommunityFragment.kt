package org.codventure.kinimom.ui.main.tabs.community

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_main_community.*
import org.codventure.kinimom.AndroidApplication
import org.codventure.kinimom.R
import org.codventure.kinimom.core.domain.Community
import org.codventure.kinimom.framework.di.ApplicationComponent
import org.codventure.kinimom.framework.extension.toast

/**
 * Created by abduaziz on 8/28/21 at 4:27 PM.
 */

class CommunityFragment : Fragment(R.layout.fragment_main_community), CommunityView {

    private val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (activity?.application as AndroidApplication).appComponent
    }

    lateinit var presenter: CommunityPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = CommunityPresenter(this)
        appComponent.inject(presenter)

        rvCommunityPosts.layoutManager = LinearLayoutManager(context)
    }

    override fun onResume() {
        super.onResume()
        presenter.fetchCommunities()
    }

    override fun showCommunities(communities: List<Community>) {
        rvCommunityPosts.adapter = CommunitiesAdapter(communities)
    }

    override fun showCommunitiesFetchError() {
        toast(getString(R.string.error_internet_connection))
    }
}