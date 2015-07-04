package com.epsz.monsterparser


public class MonsterParser(val fileReader: FileReader, val parser: ManualToJSONParser) {

    public fun parseFromFile(file: String){
        var fileContents = fileReader.readFile(file)
        parser.parse(fileContents)
    }

}


