import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import ru.netology.PostNotFoundException
import ru.netology.data.*
import ru.netology.service.WallService

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun testAdd() {
        val post = Post(
            id = 0,
            ownerId = 1,
            date = 0,
            text = "Test post",
            reposts = 0,
            views = 0,
            postType = "text",
            canDelete = true,
            canEdit = true,
            markedAsAds = false,
            isFavorite = false,
            likes = Post.Likes(),
            attachment = docAttachment(Documents())
        )
        val returnedPost = WallService.add(post)
        assertEquals(1, returnedPost.id)
//        WallService.add(post)
//
//        assertEquals(1, post.id)
    }

    @Test
    fun updateExisting() {
        val post = Post(
            id = 1,
            ownerId = 1,
            date = 0,
            text = "Привет",
            reposts = 0,
            views = 0,
            postType = "Простой",
            canDelete = true,
            canEdit = true,
            markedAsAds = false,
            isFavorite = false,
            likes = Post.Likes(),
            attachment = docAttachment(Documents())
        )

        WallService.add(post)

        val updatedPost = Post(
            id = 1,
            ownerId = 1,
            date = 0,
            text = "Новый привет",
            reposts = 0,
            views = 0,
            postType = "Обновленный",
            canDelete = true,
            canEdit = true,
            markedAsAds = false,
            isFavorite = false,
            likes = Post.Likes(),
            attachment = docAttachment(Documents())
        )

        val isUpdated = WallService.update(updatedPost)
        assertEquals(true, isUpdated)
    }

    @Test
    fun updateIsNotExisting() {
        val updatedPost = Post(
            id = 1,
            ownerId = 1,
            date = 0,
            text = "Новый привет",
            reposts = 0,
            views = 0,
            postType = "Обновленный",
            canDelete = true,
            canEdit = true,
            markedAsAds = false,
            isFavorite = false,
            likes = Post.Likes(),
            attachment = docAttachment(Documents())
        )

        val isUpdated = WallService.update(updatedPost)
        assertEquals(false, isUpdated)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        val post = Post(
            1, 1, 2000, "Привет",
            reposts = 0, views = 0,
            postType = "Простой", canDelete = true,
            canEdit = true, markedAsAds = false,
            isFavorite = false, likes = Post.Likes(), attachment = docAttachment(Documents())
        )
        val userId = "Юзер1"
        WallService.add(post)

        val comment = Comment(fromId = userId, text = "Иван Федорович Рубентшейн")
        WallService.createComment(3, comment)
    }

    @Test
    fun shouldNotThrow() {
        val post = Post(
            1, 1, 2000, "Привет",
            reposts = 0, views = 0,
            postType = "Простой", canDelete = true,
            canEdit = true, markedAsAds = false,
            isFavorite = false, likes = Post.Likes(), attachment = docAttachment(Documents())
        )
        val userId = "Юзер1"
        WallService.add(post)

        val comment = Comment(fromId = userId, text = "Иван Федорович Рубентшейн")
        WallService.createComment(1, comment)
    }
}