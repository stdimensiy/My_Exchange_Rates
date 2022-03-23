package ru.vdv.myexchangerates.domain

import com.google.gson.annotations.SerializedName
import ru.vdv.myexchangerates.domain.valutes.*

data class Valute(
    @SerializedName("AUD") var AUD: AUD? = AUD(),
    @SerializedName("AZN") var AZN: AZN? = AZN(),
    @SerializedName("GBP") var GBP: GBP? = GBP(),
    @SerializedName("AMD") var AMD: AMD? = AMD(),
    @SerializedName("BYN") var BYN: BYN? = BYN(),
    @SerializedName("BGN") var BGN: BGN? = BGN(),
    @SerializedName("BRL") var BRL: BRL? = BRL(),
    @SerializedName("HUF") var HUF: HUF? = HUF(),
    @SerializedName("HKD") var HKD: HKD? = HKD(),
    @SerializedName("DKK") var DKK: DKK? = DKK(),
    @SerializedName("USD") var USD: USD? = USD(),
    @SerializedName("EUR") var EUR: EUR? = EUR(),
    @SerializedName("INR") var INR: INR? = INR(),
    @SerializedName("KZT") var KZT: KZT? = KZT(),
    @SerializedName("CAD") var CAD: CAD? = CAD(),
    @SerializedName("KGS") var KGS: KGS? = KGS(),
    @SerializedName("CNY") var CNY: CNY? = CNY(),
    @SerializedName("MDL") var MDL: MDL? = MDL(),
    @SerializedName("NOK") var NOK: NOK? = NOK(),
    @SerializedName("PLN") var PLN: PLN? = PLN(),
    @SerializedName("RON") var RON: RON? = RON(),
    @SerializedName("XDR") var XDR: XDR? = XDR(),
    @SerializedName("SGD") var SGD: SGD? = SGD(),
    @SerializedName("TJS") var TJS: TJS? = TJS(),
    @SerializedName("TRY") var TRY: TRY? = TRY(),
    @SerializedName("TMT") var TMT: TMT? = TMT(),
    @SerializedName("UZS") var UZS: UZS? = UZS(),
    @SerializedName("UAH") var UAH: UAH? = UAH(),
    @SerializedName("CZK") var CZK: CZK? = CZK(),
    @SerializedName("SEK") var SEK: SEK? = SEK(),
    @SerializedName("CHF") var CHF: CHF? = CHF(),
    @SerializedName("ZAR") var ZAR: ZAR? = ZAR(),
    @SerializedName("KRW") var KRW: KRW? = KRW(),
    @SerializedName("JPY") var JPY: JPY? = JPY()
)
