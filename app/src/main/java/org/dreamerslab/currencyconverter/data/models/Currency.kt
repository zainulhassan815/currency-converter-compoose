package org.dreamerslab.currencyconverter.data.models

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Immutable
@Entity(
    tableName = "favorite_currencies"
)
data class Currency(
    @PrimaryKey(autoGenerate = false)
    val code: String,
    val name: String,
    val symbol: String
) {
    companion object {
        fun fromCode(code: String): Result<Currency> {
            val name = CurrencyCodeToCurrencyNameMap[code]
            val symbol = CurrencyCodeToCurrencySymbolMap[code]
            return if (name != null && symbol != null) {
                Result.success(Currency(code, name, symbol))
            } else {
                Result.failure(IllegalStateException())
            }
        }

        val Empty = Currency("", "", "")
    }

    @Ignore
    val currencyFlagUrl: String = "https://flagcdn.com/w40/${code.take(2).lowercase()}.png"
}

val SupportedCurrencyCodes = listOf(
    "AED",
    "AFN",
    "ALL",
    "AMD",
    "ANG",
    "AOA",
    "ARS",
    "AUD",
    "AWG",
    "AZN",
    "BAM",
    "BBD",
    "BDT",
    "BGN",
    "BHD",
    "BIF",
    "BMD",
    "BND",
    "BOB",
    "BRL",
    "BSD",
    "BTN",
    "BWP",
    "BYN",
    "BZD",
    "CAD",
    "CDF",
    "CHF",
    "CLP",
    "CNY",
    "COP",
    "CRC",
    "CUP",
    "CVE",
    "CZK",
    "DJF",
    "DKK",
    "DOP",
    "DZD",
    "EGP",
    "ERN",
    "ETB",
    "EUR",
    "FJD",
    "FKP",
    "FOK",
    "GBP",
    "GEL",
    "GGP",
    "GHS",
    "GIP",
    "GMD",
    "GNF",
    "GTQ",
    "GYD",
    "HKD",
    "HNL",
    "HRK",
    "HTG",
    "HUF",
    "IDR",
    "ILS",
    "IMP",
    "INR",
    "IQD",
    "IRR",
    "ISK",
    "JEP",
    "JMD",
    "JOD",
    "JPY",
    "KES",
    "KGS",
    "KHR",
    "KID",
    "KMF",
    "KRW",
    "KWD",
    "KYD",
    "KZT",
    "LAK",
    "LBP",
    "LKR",
    "LRD",
    "LSL",
    "LYD",
    "MAD",
    "MDL",
    "MGA",
    "MKD",
    "MMK",
    "MNT",
    "MOP",
    "MRU",
    "MUR",
    "MVR",
    "MWK",
    "MXN",
    "MYR",
    "MZN",
    "NAD",
    "NGN",
    "NIO",
    "NOK",
    "NPR",
    "NZD",
    "OMR",
    "PAB",
    "PEN",
    "PGK",
    "PHP",
    "PKR",
    "PLN",
    "PYG",
    "QAR",
    "RON",
    "RSD",
    "RUB",
    "RWF",
    "SAR",
    "SBD",
    "SCR",
    "SDG",
    "SEK",
    "SGD",
    "SHP",
    "SLE",
    "SOS",
    "SRD",
    "SSP",
    "STN",
    "SYP",
    "SZL",
    "THB",
    "TJS",
    "TMT",
    "TND",
    "TOP",
    "TRY",
    "TTD",
    "TVD",
    "TWD",
    "TZS",
    "UAH",
    "UGX",
    "USD",
    "UYU",
    "UZS",
    "VES",
    "VND",
    "VUV",
    "WST",
    "XAF",
    "XCD",
    "XDR",
    "XOF",
    "XPF",
    "YER",
    "ZAR",
    "ZMW",
    "ZWL"
)

val CurrencyCodeToCurrencyNameMap = mapOf(
    "AED" to "UAE Dirham",
    "AFN" to "Afghan Afghani",
    "ALL" to "Albanian Lek",
    "AMD" to "Armenian Dram",
    "ANG" to "Netherlands Antillian Guilder",
    "AOA" to "Angolan Kwanza",
    "ARS" to "Argentine Peso",
    "AUD" to "Australian Dollar",
    "AWG" to "Aruban Florin",
    "AZN" to "Azerbaijani Manat",
    "BAM" to "Bosnia and Herzegovina Mark",
    "BBD" to "Barbados Dollar",
    "BDT" to "Bangladeshi Taka",
    "BGN" to "Bulgarian Lev",
    "BHD" to "Bahraini Dinar",
    "BIF" to "Burundian Franc",
    "BMD" to "Bermudian Dollar",
    "BND" to "Brunei Dollar",
    "BOB" to "Bolivian Boliviano",
    "BRL" to "Brazilian Real",
    "BSD" to "Bahamian Dollar",
    "BTN" to "Bhutanese Ngultrum",
    "BWP" to "Botswana Pula",
    "BYN" to "Belarusian Ruble",
    "BZD" to "Belize Dollar",
    "CAD" to "Canadian Dollar",
    "CDF" to "Congolese Franc",
    "CHF" to "Swiss Franc",
    "CLP" to "Chilean Peso",
    "CNY" to "Chinese Renminbi",
    "COP" to "Colombian Peso",
    "CRC" to "Costa Rican Colon",
    "CUP" to "Cuban Peso",
    "CVE" to "Cape Verdean Escudo",
    "CZK" to "Czech Koruna",
    "DJF" to "Djiboutian Franc",
    "DKK" to "Danish Krone",
    "DOP" to "Dominican Peso",
    "DZD" to "Algerian Dinar",
    "EGP" to "Egyptian Pound",
    "ERN" to "Eritrean Nakfa",
    "ETB" to "Ethiopian Birr",
    "EUR" to "Euro",
    "FJD" to "Fiji Dollar",
    "FKP" to "Falkland Islands Pound",
    "FOK" to "Faroese Króna",
    "GBP" to "Pound Sterling",
    "GEL" to "Georgian Lari",
    "GGP" to "Guernsey Pound",
    "GHS" to "Ghanaian Cedi",
    "GIP" to "Gibraltar Pound",
    "GMD" to "Gambian Dalasi",
    "GNF" to "Guinean Franc",
    "GTQ" to "Guatemalan Quetzal",
    "GYD" to "Guyanese Dollar",
    "HKD" to "Hong Kong Dollar",
    "HNL" to "Honduran Lempira",
    "HRK" to "Croatian Kuna",
    "HTG" to "Haitian Gourde",
    "HUF" to "Hungarian Forint",
    "IDR" to "Indonesian Rupiah",
    "ILS" to "Israeli New Shekel",
    "IMP" to "Manx Pound",
    "INR" to "Indian Rupee",
    "IQD" to "Iraqi Dinar",
    "IRR" to "Iranian Rial",
    "ISK" to "Icelandic Króna",
    "JEP" to "Jersey Pound",
    "JMD" to "Jamaican Dollar",
    "JOD" to "Jordanian Dinar",
    "JPY" to "Japanese Yen",
    "KES" to "Kenyan Shilling",
    "KGS" to "Kyrgyzstani Som",
    "KHR" to "Cambodian Riel",
    "KID" to "Kiribati Dollar",
    "KMF" to "Comorian Franc",
    "KRW" to "South Korean Won",
    "KWD" to "Kuwaiti Dinar",
    "KYD" to "Cayman Islands Dollar",
    "KZT" to "Kazakhstani Tenge",
    "LAK" to "Lao Kip",
    "LBP" to "Lebanese Pound",
    "LKR" to "Sri Lanka Rupee",
    "LRD" to "Liberian Dollar",
    "LSL" to "Lesotho Loti",
    "LYD" to "Libyan Dinar",
    "MAD" to "Moroccan Dirham",
    "MDL" to "Moldovan Leu",
    "MGA" to "Malagasy Ariary",
    "MKD" to "Macedonian Denar",
    "MMK" to "Burmese Kyat",
    "MNT" to "Mongolian Tögrög",
    "MOP" to "Macanese Pataca",
    "MRU" to "Mauritanian Ouguiya",
    "MUR" to "Mauritian Rupee",
    "MVR" to "Maldivian Rufiyaa",
    "MWK" to "Malawian Kwacha",
    "MXN" to "Mexican Peso",
    "MYR" to "Malaysian Ringgit",
    "MZN" to "Mozambican Metical",
    "NAD" to "Namibian Dollar",
    "NGN" to "Nigerian Naira",
    "NIO" to "Nicaraguan Córdoba",
    "NOK" to "Norwegian Krone",
    "NPR" to "Nepalese Rupee",
    "NZD" to "New Zealand Dollar",
    "OMR" to "Omani Rial",
    "PAB" to "Panamanian Balboa",
    "PEN" to "Peruvian Sol",
    "PGK" to "Papua New Guinean Kina",
    "PHP" to "Philippine Peso",
    "PKR" to "Pakistani Rupee",
    "PLN" to "Polish Złoty",
    "PYG" to "Paraguayan Guaraní",
    "QAR" to "Qatari Riyal",
    "RON" to "Romanian Leu",
    "RSD" to "Serbian Dinar",
    "RUB" to "Russian Ruble",
    "RWF" to "Rwandan Franc",
    "SAR" to "Saudi Riyal",
    "SBD" to "Solomon Islands Dollar",
    "SCR" to "Seychellois Rupee",
    "SDG" to "Sudanese Pound",
    "SEK" to "Swedish Krona",
    "SGD" to "Singapore Dollar",
    "SHP" to "Saint Helena Pound",
    "SLE" to "Sierra Leonean Leone",
    "SLL" to "Sierra Leonean Leone",
    "SOS" to "Somali Shilling",
    "SRD" to "Surinamese Dollar",
    "SSP" to "South Sudanese Pound",
    "STN" to "São Tomé and Príncipe Dobra",
    "SYP" to "Syrian Pound",
    "SZL" to "Eswatini Lilangeni",
    "THB" to "Thai Baht",
    "TJS" to "Tajikistani Somoni",
    "TMT" to "Turkmenistan Manat",
    "TND" to "Tunisian Dinar",
    "TOP" to "Tongan Paʻanga",
    "TRY" to "Turkish Lira",
    "TTD" to "Trinidad and Tobago Dollar",
    "TVD" to "Tuvaluan Dollar",
    "TWD" to "New Taiwan Dollar",
    "TZS" to "Tanzanian Shilling",
    "UAH" to "Ukrainian Hryvnia",
    "UGX" to "Ugandan Shilling",
    "USD" to "United States Dollar",
    "UYU" to "Uruguayan Peso",
    "UZS" to "Uzbekistani So'm",
    "VES" to "Venezuelan Bolívar Soberano",
    "VND" to "Vietnamese Đồng",
    "VUV" to "Vanuatu Vatu",
    "WST" to "Samoan Tālā",
    "XAF" to "Central African CFA Franc",
    "XCD" to "East Caribbean Dollar",
    "XDR" to "Special Drawing Rights",
    "XOF" to "West African CFA franc",
    "XPF" to "CFP Franc",
    "YER" to "Yemeni Rial",
    "ZAR" to "South African Rand",
    "ZMW" to "Zambian Kwacha",
    "ZWL" to "Zimbabwean Dollar"
)

val CurrencyCodeToCurrencySymbolMap = mapOf(
    "AED" to "AED",
    "AFN" to "؋",
    "ALL" to "L",
    "AMD" to "֏",
    "ANG" to "ƒ",
    "AOA" to "Kz",
    "ARS" to "$",
    "AUD" to "A$",
    "AWG" to "ƒ",
    "AZN" to "₼",
    "BAM" to "KM",
    "BBD" to "$",
    "BDT" to "৳",
    "BGN" to "лв",
    "BHD" to ".د.ب",
    "BIF" to "FBu",
    "BMD" to "$",
    "BND" to "B$",
    "BOB" to "Bs",
    "BRL" to "R$",
    "BSD" to "B$",
    "BTN" to "Nu",
    "BWP" to "P",
    "BYN" to "Br",
    "BZD" to "BZ$",
    "CAD" to "CA$",
    "CDF" to "FC",
    "CHF" to "CHF",
    "CLP" to "$",
    "CNY" to "¥",
    "COP" to "$",
    "CRC" to "₡",
    "CUP" to "CUC$",
    "CVE" to "CVE",
    "CZK" to "Kč",
    "DJF" to "Fdj",
    "DKK" to "kr",
    "DOP" to "RD$",
    "DZD" to "دج",
    "EGP" to "E£",
    "ERN" to "Nkf",
    "ETB" to "Br",
    "EUR" to "€",
    "FJD" to "FJ$",
    "FKP" to "FK£",
    "FOK" to "kr",
    "GBP" to "£",
    "GEL" to "ლარი",
    "GGP" to "£",
    "GHS" to "GH₵",
    "GIP" to "£",
    "GMD" to "D",
    "GNF" to "FG",
    "GTQ" to "Q",
    "GYD" to "G$",
    "HKD" to "$",
    "HNL" to "L",
    "HRK" to "kn",
    "HTG" to "G",
    "HUF" to "ft",
    "IDR" to "Rp",
    "ILS" to "₪",
    "IMP" to "£",
    "INR" to "₹",
    "IQD" to "ع.د",
    "IRR" to "﷼",
    "ISK" to "kr",
    "JEP" to "£",
    "JMD" to "J$",
    "JOD" to "ينار",
    "JPY" to "¥",
    "KES" to "KSh",
    "KGS" to "som",
    "KHR" to "៛",
    "KID" to "$",
    "KMF" to "CF",
    "KRW" to "₩",
    "KWD" to "ك",
    "KYD" to "CI$",
    "KZT" to "₸",
    "LAK" to "₭",
    "LBP" to "ل.ل",
    "LKR" to "Rs",
    "LRD" to "LD$",
    "LSL" to "L",
    "LYD" to "LD",
    "MAD" to "DH",
    "MDL" to "L",
    "MGA" to "Ar",
    "MKD" to "ден",
    "MMK" to "K",
    "MNT" to "₮",
    "MOP" to "MOP$",
    "MRU" to "UM",
    "MUR" to "₨",
    "MVR" to "MRf",
    "MWK" to "K",
    "MXN" to "$",
    "MYR" to "RM",
    "MZN" to "MT",
    "NAD" to "N$",
    "NGN" to "₦",
    "NIO" to "C$",
    "NOK" to "kr",
    "NPR" to "Rs",
    "NZD" to "$",
    "OMR" to "ر.ع",
    "PAB" to "B/.",
    "PEN" to "S/.",
    "PGK" to "K",
    "PHP" to "₱",
    "PKR" to "Rs",
    "PLN" to "zł",
    "PYG" to "₲",
    "QAR" to "ر.ق",
    "RON" to "lei",
    "RSD" to "RSD",
    "RUB" to "₽",
    "RWF" to "R₣",
    "SAR" to "SR",
    "SBD" to "SI$",
    "SCR" to "SR",
    "SDG" to "SDG",
    "SEK" to "kr",
    "SGD" to "S$",
    "SHP" to "£",
    "SLE" to "Le",
    "SLL" to "Le",
    "SOS" to "Sh.So.",
    "SRD" to "Sr$",
    "SSP" to "SS£",
    "STN" to "Db",
    "SYP" to "£S",
    "SZL" to "L",
    "THB" to "฿",
    "TJS" to "TJS",
    "TMT" to "m",
    "TND" to "د.ت",
    "TOP" to "T$",
    "TRY" to "₺",
    "TTD" to "TT$",
    "TVD" to "$",
    "TWD" to "NT$",
    "TZS" to "TSh",
    "UAH" to "₴",
    "UGX" to "USh",
    "USD" to "US$",
    "UYU" to "\$U",
    "UZS" to "som",
    "VES" to "Bs.",
    "VND" to "₫",
    "VUV" to "VT",
    "WST" to "$",
    "XAF" to "FCFA",
    "XCD" to "$",
    "XDR" to "SDR",
    "XOF" to "CFA",
    "XPF" to "F",
    "YER" to "﷼",
    "ZAR" to "R",
    "ZMW" to "ZK",
    "ZWL" to "$"
)