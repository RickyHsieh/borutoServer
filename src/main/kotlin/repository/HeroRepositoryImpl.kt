package com.purplestudio.repository

import com.purplestudio.models.ApiResponse
import com.purplestudio.models.Hero

const val PREVIOUS_PAGE_KEY: String = "prevPage"
const val NEXT_PAGE_KEY: String = "nextPage"
class HeroRespositoryImpl: HeroRepository {

    override val heroes: Map<Int, List<Hero>> by lazy { initializeHeroes() }

    private fun initializeHeroes(): Map<Int, List<Hero>> {
        return mapOf(
            1 to page1,
            2 to page2,
            3 to page3,
            4 to page4,
            5 to page5
        )
    }

    override val page1 = listOf(
        Hero(
            id = 1,
            name = "Amado",
            image = "/images/amado.jpg",
            rating = 4.8,
            power = 85.0,
            month = "January",
            day = "15",
            family = listOf("Unknown"),
            abilities = listOf("Scientific Ninja Tools"),
            natureTypes = listOf("None")
        ),
        Hero(
            id = 2,
            name = "Boruto",
            image = "/images/boruto.png",
            rating = 5.0,
            power = 92.5,
            month = "March",
            day = "27",
            family = listOf("Naruto", "Hinata", "Himawari"),
            abilities = listOf("Shadow Clone Jutsu", "Rasengan", "Karma"),
            natureTypes = listOf("Wind", "Lightning")
        ),
        Hero(
            id = 3,
            name = "Code",
            image = "/images/code.jpg",
            rating = 4.2,
            power = 90.0,
            month = "June",
            day = "10",
            family = listOf("Unknown"),
            abilities = listOf("Claw Marks", "Enhanced Strength"),
            natureTypes = listOf("None")
        )
    )
    override val page2 = listOf(
        Hero(
            id = 4,
            name = "Ishiki",
            image = "/images/ishiki.jpg",
            rating = 5.0,
            power = 98.0,
            month = "July",
            day = "1",
            family = listOf("None"),
            abilities = listOf("Sukunahikona", "Daikokuten"),
            natureTypes = listOf("None")
        ),
        Hero(
            id = 5,
            name = "Kakashi",
            image = "/images/kakashi.png",
            rating = 4.9,
            power = 95.0,
            month = "September",
            day = "15",
            family = listOf("Sakumo Hatake"),
            abilities = listOf("Lightning Blade", "Sharingan"),
            natureTypes = listOf("Lightning", "Water")
        ),
        Hero(
            id = 6,
            name = "Kawaki",
            image = "/images/kawaki.jpg",
            rating = 4.7,
            power = 93.0,
            month = "October",
            day = "21",
            family = listOf("Unknown"),
            abilities = listOf("Karma", "Regeneration"),
            natureTypes = listOf("None")
        )
    )
    override val page3 = listOf(
        Hero(
            id = 7,
            name = "Koji",
            image = "/images/koji.jpg",
            rating = 4.5,
            power = 87.0,
            month = "November",
            day = "5",
            family = listOf("Unknown"),
            abilities = listOf("Toad Summoning", "Fire Style"),
            natureTypes = listOf("Fire")
        ),
        Hero(
            id = 8,
            name = "Mitsuki",
            image = "/images/mitsuki.jpg",
            rating = 4.6,
            power = 88.0,
            month = "December",
            day = "25",
            family = listOf("Orochimaru"),
            abilities = listOf("Snake Clone", "Sage Transformation"),
            natureTypes = listOf("Wind", "Lightning")
        ),
        Hero(
            id = 9,
            name = "Momoshiki",
            image = "/images/momoshiki.jpg",
            rating = 5.0,
            power = 99.0,
            month = "February",
            day = "14",
            family = listOf("Kinshiki"),
            abilities = listOf("Absorption", "Rinnegan"),
            natureTypes = listOf("All")
        )
    )
    override val page4 = listOf(
        Hero(
            id = 10,
            name = "Naruto",
            image = "/images/naruto.jpg",
            rating = 5.0,
            power = 100.0,
            month = "October",
            day = "10",
            family = listOf("Boruto", "Hinata", "Himawari"),
            abilities = listOf("Shadow Clone Jutsu", "Rasengan", "Sage Mode"),
            natureTypes = listOf("Wind", "Earth")
        ),
        Hero(
            id = 11,
            name = "Orochimaru",
            image = "/images/orochimaru.jpg",
            rating = 4.3,
            power = 89.0,
            month = "April",
            day = "23",
            family = listOf("Mitsuki"),
            abilities = listOf("Snake Summoning", "Immortality"),
            natureTypes = listOf("Earth", "Water")
        ),
        Hero(
            id = 12,
            name = "Sakura",
            image = "/images/sakura.jpg",
            rating = 4.2,
            power = 85.0,
            month = "March",
            day = "28",
            family = listOf("Sarada", "Kizashi", "Mebuki"),
            abilities = listOf("Chakra Control", "Super Strength"),
            natureTypes = listOf("None")
        )
    )
    override val page5 = listOf(
        Hero(
            id = 13,
            name = "Sarada",
            image = "/images/sarada.jpg",
            rating = 4.8,
            power = 90.0,
            month = "July",
            day = "23",
            family = listOf("Sasuke", "Sakura"),
            abilities = listOf("Sharingan", "Fire Style"),
            natureTypes = listOf("Fire", "Lightning")
        ),
        Hero(
            id = 14,
            name = "Sasuke",
            image = "/images/sasuke.jpg",
            rating = 5.0,
            power = 99.0,
            month = "July",
            day = "23",
            family = listOf("Sarada", "Sakura"),
            abilities = listOf("Amaterasu", "Rinnegan"),
            natureTypes = listOf("Fire", "Lightning")
        ),
        Hero(
            id = 15,
            name = "Urashiki",
            image = "/images/urashiki.jpg",
            rating = 4.6,
            power = 92.0,
            month = "May",
            day = "30",
            family = listOf("Otsutsuki Clan"),
            abilities = listOf("Time Manipulation", "Fishing Rod"),
            natureTypes = listOf("All")
        )
    )
    override suspend fun getAllHeroes(page: Int): ApiResponse {
        if (page !in 1..5) {
            return ApiResponse(
                success = false,
                message = "Invalid page number. Must be between 1 and 5.",
                prevPage = null,
                nextPage = null,
                heroes = emptyList()
            )
        }
        return ApiResponse(
            success = true,
            message = "ok",
            prevPage = calculatePage(page = page)[PREVIOUS_PAGE_KEY],
            nextPage = calculatePage(page = page)[NEXT_PAGE_KEY],
            heroes = heroes[page] ?: emptyList()
        )
    }


    private fun calculatePage(page: Int): Map<String, Int?> {
        var prevPage: Int? = if (page > 1) page - 1 else null
        var nextPage: Int? = if (page < 5) page + 1 else null
        return mapOf(PREVIOUS_PAGE_KEY to prevPage, NEXT_PAGE_KEY to nextPage)
    }


    override suspend fun searchHeroes(name: String?): ApiResponse {
        val foundHeroes = findHeroes(query = name)
        return if (foundHeroes.isEmpty()) {
            ApiResponse(
                success = false,
                message = "No heroes found matching the query.",
                heroes = emptyList()
            )
        } else {
            ApiResponse(
                success = true,
                message = "ok",
                heroes = foundHeroes
            )
        }
    }


    private fun findHeroes(query: String?): List<Hero> {
        // 如果 name 為空或 null，直接返回空列表
        if (query.isNullOrEmpty()) return emptyList()

        // 遍歷 heroes 並查找匹配的
        return heroes.flatMap { (_, heroList) ->
            heroList.filter { hero ->
                hero.name.lowercase().contains(query.lowercase())
            }
        }
    }

}