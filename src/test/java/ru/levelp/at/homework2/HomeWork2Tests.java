package ru.levelp.at.homework2;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


    public class HomeWork2Tests {
        private HappyTicket happyTicket;
        @BeforeClass(groups = {"positive", "negative"})
        public void beforeClass() {
            happyTicket = new HappyTicket();
        }

        @Test(groups = {"positive"}, dataProvider = "HappyPath",
                dataProviderClass = HomeWork2DataProvider.class)
        public void testLuckyTicket(Integer number) {
            assertEquals(happyTicket.isMyTicketLucky(number), true,
                    "Ошибка проверки на счастливый билет");
        }

        @Test(groups = {"negative"}, dataProvider = "notHappyPath",
                dataProviderClass = HomeWork2DataProvider.class)
        public void testNotLuckyTicket(Integer number) {
            assertEquals(happyTicket.isMyTicketLucky(number), false,
                    "Ошибка проверки на не счастливый билет");
        }

        @Test(groups = {"negative"}, dataProvider = "sizeOfNumberNotCorrect",
                dataProviderClass = HomeWork2DataProvider.class, expectedExceptions = {IllegalArgumentException.class})
        public void testSizeNumber(Integer number) {assertEquals(happyTicket.isMyTicketLucky(number), false,
                "Номер в билете не корректен");

        }

    }


