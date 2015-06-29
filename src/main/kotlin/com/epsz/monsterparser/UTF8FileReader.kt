package com.epsz.monsterparser

import java.nio.file.Files
import java.nio.file.Paths

interface FileReader {
    fun readFile(filename: String): String
}

public class UTF8FileReader: FileReader {
    override fun readFile(filename: String): String {
        val encoded = Files.readAllBytes(Paths.get(filename));
        return String(encoded, Charsets.UTF_8);
    }

}

