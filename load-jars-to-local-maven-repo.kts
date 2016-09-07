import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

if (args.length > 0)
    File(args[0]).listFiles().filter { it.name.contains(".jar") }.forEach { file ->
        BufferedReader(InputStreamReader(ProcessBuilder("mvn",
                "install:install-file " +
                        "-Dfile=\"${file.absolutePath}\" " +
                        "-DgroupId=com.otoil " +
                        "-DartifactId=${file.name.replace(".jar", "")} " +
                        "-Dversion=1.0.0" +
                        "-Dpackaging=jar")
                .start().inputStream)).useLines { println(it) }
    }
else
    println("Укажите директорию")