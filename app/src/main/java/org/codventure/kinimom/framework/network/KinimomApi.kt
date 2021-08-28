package org.codventure.kinimom.framework.network

import org.codventure.kinimom.core.data.request.*
import org.codventure.kinimom.core.data.response.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

/**
 * Created by abduaziz on 7/17/21 at 10:19 PM.
 */

internal interface KinimomApi {

    @POST("socialLogin")
    fun signUp(@Body body: SignUpRequest): Call<SignUpResponse>

    @POST("api/userNicknameCheck")
    fun checkNickname(
        @Header("Authorization") Authorization: String,
        @Body body: CheckNicknameRequest
    ): Call<CheckNicknameResponse>


    @POST("api/userInfoSave")
    fun userInfoSave(
        @Header("Authorization") Authorization: String,
        @Body body: UserInfoSaveRequest
    ): Call<UserInfoSaveResponse>

    @POST("api/communityList")
    fun communityList(
        @Header("Authorization") Authorization: String,
        @Body body: CommunityListRequest
    ): Call<CommunityListResponse>

    @POST("api/communityGetOne")
    fun communityDetail(
        @Header("Authorization") Authorization: String,
        @Body body: CommunityDetailRequest
    ): Call<CommunityDetailResponse>
}