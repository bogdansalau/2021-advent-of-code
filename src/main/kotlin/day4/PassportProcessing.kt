package day4

import java.util.*

data class Passport(
    val byr: Int?,
    val iyr: Int?,
    val eyr: Int?,
    val hgt: String?,
    val hcl: String?,
    val ecl: String?,
    val pid: String?,
    val cid: Int?
)

/**
 * The automatic passport scanners are slow because they're having trouble detecting which passports have all required fields. The expected fields are as follows:
 * byr (Birth Year)
 * iyr (Issue Year)
 * eyr (Expiration Year)
 * hgt (Height)
 * hcl (Hair Color)
 * ecl (Eye Color)
 * pid (Passport ID)
 * cid (Country ID)
 *
 * Passport data is validated in batch files (your puzzle input).
 * Each passport is represented as a sequence of key:value pairs separated by spaces or newlines. Passports are separated by blank lines.
 * Here is an example batch file containing four passports:
 * ---------------------------------------------
 * ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
 * byr:1937 iyr:2017 cid:147 hgt:183cm
 *
 * iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884
 * hcl:#cfa07d byr:1929
 *
 * hcl:#ae17e1 iyr:2013
 * eyr:2024
 * ecl:brn pid:760753108 byr:1931
 * hgt:179cm
 *
 * hcl:#cfa07d eyr:2025 pid:166559648
 * iyr:2011 ecl:brn hgt:59in
 * ---------------------------------------------
 * The first passport is valid - all eight fields are present. The second passport is invalid - it is missing hgt (the Height field).
 *
 * The third passport is interesting; the only missing field is cid,
 * so it looks like data from North Pole Credentials, not a passport at all!
 * Surely, nobody would mind if you made the system temporarily ignore missing cid fields. Treat this "passport" as valid.
 *
 * The fourth passport is missing two fields, cid and byr. Missing cid is fine, but missing any other field is not, so this passport is invalid.
 *
 * According to the above rules, your improved system would report 2 valid passports.
 *
 * Count the number of valid passports - those that have all required fields. Treat cid as optional. In your batch file, how many passports are valid?
 */
fun countValidPassports(passwords: String): Int {
    return parsePassports(passwords).filter { validatePassPolicy(it) }.filter { validateFields(it) }.count()
}

fun validateFields(pass: Passport): Boolean {
    return isValidByr(pass) && isValidIyr(pass) && isValidEyr(pass) && isValidHgt(pass) && isValidHcl(pass) && isValidEcl(pass) && isValidPid(pass)
}

private fun isValidByr(pass: Passport): Boolean {
    return pass.byr!! >= 1920 && pass.byr <= 2002
}

private fun isValidIyr(pass: Passport): Boolean {
    return pass.iyr!! >= 2010 && pass.iyr <= 2020
}

fun isValidEyr(pass: Passport): Boolean {
    return pass.eyr!! >= 2020 && pass.eyr <= 2030
}

fun isValidHgt(pass: Passport): Boolean {
    if (pass.hgt!!.endsWith("cm")) {
        val hgt: Int = try {
            pass.hgt.filterNot { it == 'c' || it == 'm' }.toInt()
        } catch (e: NumberFormatException) {
            -1
        }
        return hgt in 150..193
    } else if (pass.hgt.endsWith("in")) {
        val hgt: Int = try {
            pass.hgt.filterNot { it == 'i' || it == 'n' }.toInt()
        } catch (e: NumberFormatException) {
            -1
        }
        return hgt in 59..76
    } else return false
}

fun isValidHcl(pass: Passport): Boolean {
    val i = pass.hcl!!.map { it.isLetterOrDigit() }.filter { it }.count()
    return pass.hcl!![0] == '#' && i == 6
}

fun isValidEcl(pass: Passport): Boolean {
    return pass.ecl == "amb" || pass.ecl == "blu" || pass.ecl == "brn" || pass.ecl == "gry" || pass.ecl == "grn" || pass.ecl == "hzl" || pass.ecl == "oth"
}

fun isValidPid(pass: Passport): Boolean {
    val i = pass.pid!!.map { it.isDigit() }.count()
    return i == 9
}

private fun validatePassPolicy(pass: Passport): Boolean {
    return pass.byr != null &&
            pass.iyr != null &&
            pass.eyr != null &&
            pass.hgt != null &&
            pass.hcl != null &&
            pass.ecl != null &&
            pass.pid != null
}

private fun parsePassports(passports: String): List<Passport> {
    return passports
        .trim()
        .split("\n\n")
        .map {
            val scanner = Scanner(it)

            var byr: Int? = null
            var iyr: Int? = null
            var eyr: Int? = null
            var hgt: String? = null
            var hcl: String? = null
            var ecl: String? = null
            var pid: String? = null
            var cid: Int? = null

            while (scanner.hasNext()) {
                val field = scanner.next().split(":")
                when (field[0]) {
                    "byr" -> byr = try {
                        field[1].toInt()
                    } catch (e: NumberFormatException) {
                        -1
                    }
                    "iyr" -> iyr = try {
                        field[1].toInt()
                    } catch (e: NumberFormatException) {
                        -1
                    }
                    "eyr" -> eyr = try {
                        field[1].toInt()
                    } catch (e: NumberFormatException) {
                        -1
                    }
                    "hgt" -> hgt = field[1]
                    "hcl" -> hcl = field[1]
                    "ecl" -> ecl = field[1]
                    "pid" -> pid = field[1]
                    "cid" -> cid = try {
                        field[1].toInt()
                    } catch (e: NumberFormatException) {
                        -1
                    }
                    else -> {
                    }
                }
            }

            Passport(byr, iyr, eyr, hgt, hcl, ecl, pid, cid)
        }
}
