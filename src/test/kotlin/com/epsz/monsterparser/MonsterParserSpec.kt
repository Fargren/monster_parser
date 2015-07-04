package com.epsz.monsterparser

import com.epsz.monsterparser.FileReader
import com.epsz.monsterparser.MonsterParser
import com.google.gson.Gson
import org.hamcrest.CoreMatchers.*
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.junit.*
import org.jetbrains.spek.api.*
import org.junit.Assert.*

class MonsterParserSpec : Spek(){


    init{
        given("A monster parser"){
            val fileReader = SuccessfulFileReader()
            val parser = SuccessfulManualToJSONParser()
            val monsterParser: MonsterParser = MonsterParser(fileReader, parser)

            on("parse monsters from a file"){
                val filename:String = "fake_file.txt"
                monsterParser.parseFromFile(filename)

                it("opens the file") {
                    assertThat(fileReader.readFilename, `is`("fake_file.txt"));
                }

                it("parses the file with the contents of the file") {
                    assertThat(parser.parsedText, `is`("file contents!"));
                }

                it ("creates a new file with the results fo the parse") {
                }
            }

        }
    }

}

class SuccessfulManualToJSONParser: ManualToJSONParser {
    public var parsedText: String = ""

    override fun parse(manualText: String): Gson {
        parsedText = manualText
        return Gson()
    }
}

class SuccessfulFileReader: FileReader {

    public var readFilename: String = ""

    override fun readFile(filename:String): String {
        readFilename = filename
        return "file contents!"
    }

}

