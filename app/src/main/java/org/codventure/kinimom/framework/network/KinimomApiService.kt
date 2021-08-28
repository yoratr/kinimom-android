package org.codventure.kinimom.framework.network

import org.codventure.kinimom.core.data.request.*
import org.codventure.kinimom.core.data.response.CheckNicknameResponse
import org.codventure.kinimom.core.data.response.CommunityDetailResponse
import org.codventure.kinimom.core.data.response.CommunityListResponse
import org.codventure.kinimom.core.data.response.UserInfoSaveResponse
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by abduaziz on 7/17/21 at 10:21 PM.
 */

@Singleton
class KinimomApiService
@Inject constructor(retrofit: Retrofit) : KinimomApi {
    private val api by lazy { retrofit.create(KinimomApi::class.java) }

    override fun signUp(body: SignUpRequest) = api.signUp(body)

    override fun checkNickname(
        Authorization: String,
        body: CheckNicknameRequest
    ): Call<CheckNicknameResponse> = api.checkNickname(Authorization, body)

    override fun userInfoSave(
        Authorization: String,
        body: UserInfoSaveRequest
    ): Call<UserInfoSaveResponse> = api.userInfoSave(Authorization, body)

    override fun communityList(
        Authorization: String,
        body: CommunityListRequest
    ): Call<CommunityListResponse> = api.communityList(Authorization, body)

    override fun communityDetail(
        Authorization: String,
        body: CommunityDetailRequest
    ): Call<CommunityDetailResponse> = api.communityDetail(Authorization, body)
}