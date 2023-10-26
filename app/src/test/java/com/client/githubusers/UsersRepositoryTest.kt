package com.client.githubusers

import app.cash.turbine.test
import com.client.githubusers.data.repository.UsersRepository
import com.client.githubusers.data.util.StubUtil
import com.client.githubusers.di.appModule
import com.client.githubusers.di.repositoryModule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldNotBe
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.koin.core.context.stopKoin
import org.koin.core.logger.Level
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.mock.MockProviderRule
import org.koin.test.mock.declareMock
import org.mockito.Mockito
import org.mockito.kotlin.given

class UsersRepositoryTest : KoinTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testScope = TestScope(UnconfinedTestDispatcher())
    private val usersStub = StubUtil.getDummyUsers()
    private val userDetailStub = StubUtil.getDummyUserDetail()

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        printLogger(Level.DEBUG)
        modules(appModule, repositoryModule)
    }

    @get:Rule
    val mockProvider = MockProviderRule.create { clazz ->
        Mockito.mock(clazz.java)
    }

    @Test
    fun `When getUsers() is called, then the users were retrieved`() = testScope.runTest {
        val usersRepository = declareMock<UsersRepository> {
            given { getUsers() }.willReturn(flowOf(usersStub))
        }

        usersRepository.getUsers().test {
            awaitItem().size shouldBeEqualTo 2
            awaitComplete()
        }
    }

    @Test
    fun `When getUsers() is called, then check if call was successful`() = testScope.runTest {
        val usersRepository = declareMock<UsersRepository> {
            given { getUsers() }.willReturn(flowOf(usersStub))
        }

        usersRepository.getUsers().test {
            awaitItem().size shouldNotBe 0
            awaitComplete()
        }
    }

    @Test
    fun `When getUserDetailByName() is called, then the user detail was retrieved`() =
        testScope.runTest {
            val userName = "login"
            val usersRepository = declareMock<UsersRepository> {
                given { getUserDetailsByName(userName) }.willReturn(flowOf(userDetailStub))
            }

            usersRepository.getUserDetailsByName(userName).test {
                awaitItem().login shouldBeEqualTo userName
                awaitComplete()
            }
        }

    @After
    fun stopKoinAfterTest() = stopKoin()
}