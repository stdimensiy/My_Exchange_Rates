package ru.vdv.myexchangerates.model.retrofit

import ru.vdv.myexchangerates.model.BaseConstants
import ru.vdv.myexchangerates.model.api.IAPIDailyRuService

object Common {
    val retrofitService: IAPIDailyRuService
        get() {
            return RetrofitClientDR.getClient(BaseConstants.BASE_URL)
                .create(IAPIDailyRuService::class.java)
        }
}