package com.epsz.monsterparser

import com.google.gson.Gson


interface ManualToJSONParser {
    open fun parse(manualText: String): Gson
}


public class GsonManualParser: ManualToJSONParser {
    override fun parse(manualText: String): Gson {
        throw UnsupportedOperationException()
    }
}