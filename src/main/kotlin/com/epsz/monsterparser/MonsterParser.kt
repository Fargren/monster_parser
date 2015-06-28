package com.epsz.monsterparser

public class MonsterParser(val fileReader: FileReader) {

    public fun parseFromFile(file: String){
        fileReader.readFile(file)
    }

}

interface FileReader {
    fun readFile(file: String): String

}
