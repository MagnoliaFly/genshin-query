import kotlinx.coroutines.runBlocking
import me.xiaocao.GenshinQuery
import java.io.File
import kotlin.test.BeforeTest
import kotlin.test.Test


class SimpleTest {

    lateinit var genshinQuery: GenshinQuery


    @BeforeTest
    fun before() {
        genshinQuery = GenshinQuery(
            salt = "xV8v4Qu54lUKrEYFZkJhB8cuOh9Asafs",
            version = "2.11.1",
            type = "5",
            cookie = File("./cookie").readText()
        )

    }

    @Test
    fun testQueryPlayInfo() {
        runBlocking {
            //cn_qd01
            //cn_gf01
            val result = genshinQuery.queryPlayInfo("", "cn_gf01")
            if (result.success) {
                val playInfo = result.data
                println(playInfo)
            } else {
                println("查询失败:${result.message}")
            }
            println(result)
        }

    }

    @Test
    fun testQuerySpiralAbyssInfo() {
        runBlocking {
            //1这一期 2上一期
            val result = genshinQuery.querySpiralAbyssInfo("1", "", "cn_gf01")
            if (result.success) {
                val playInfo = result.data
                println(playInfo)
            } else {
                println("查询失败:${result.message}")
            }
        }
    }
}