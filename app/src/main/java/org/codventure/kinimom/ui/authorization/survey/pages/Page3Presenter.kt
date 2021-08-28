package org.codventure.kinimom.ui.authorization.survey.pages

import org.codventure.kinimom.core.interactors.CheckNickname
import org.codventure.kinimom.framework.extension.doAsync
import org.codventure.kinimom.framework.extension.uiThread
import javax.inject.Inject

/**
 * Created by abduaziz on 8/16/21 at 4:08 PM.
 */

class Page3Presenter(var view: Page3View) {

    @Inject
    lateinit var checkNickname: CheckNickname

    fun checkUserNickname(nickname: String){
        if (!validateNickname(nickname)) {
            view.showInvalidNicknameError()
            return
        }
        doAsync {
            val isValidNickname = checkNickname(nickname)
            uiThread {
                if (isValidNickname == null){
                    view.showInternetConnectionError()
                    return@uiThread
                }

                if (isValidNickname){
                    view.showValidNickname(nickname)
                }else{
                    view.showInvalidNicknameError()
                }
            }
        }
    }

    private val disallowedChars = "[ !\"#$%&'()*+,-./:;<=>?@\\[\\\\\\]^_`{|}~]+"
    private fun validateNickname(nickname: String): Boolean {
        if (nickname.length > 10)
            return false

        for (c in nickname){
            if (disallowedChars.contains(c))
                return false
        }
        return true
    }

}