import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun toPay_should() {
        var card = "Maestro"   //тип карты

        var previousTransfers = 15_000  //сумма прошлого платежа в копейках

        var pay = 1500500 //сумма платежа в копейках

        previousTransfers = pay + previousTransfers

        var total = toPay(pay = pay, previousTransfers = previousTransfers, card = card)

        assertEquals(
            "Вы переводите 1500500 , у вас карта: Maestro : 11253.75",
            total
        )
    }

    @Test
    fun toPay_MasterCard() {
        var card = "MasterCard"   //тип карты

        var previousTransfers = 0  //сумма прошлого платежа в копейках

        var pay = 35 //сумма платежа в копейках

        previousTransfers = pay + previousTransfers

        var total = toPay(pay = pay, previousTransfers = previousTransfers, card = card)

        assertEquals(
            "Вы переводите 35 , у вас карта: MasterCard : Комиссия 35 Рублей",
            total
        )
    }

    @Test
    fun toPay_Mir() {
        var card = "Мир"   //тип карты

        var previousTransfers = 0  //сумма прошлого платежа в копейках

        var pay = 7500001 //сумма платежа в копейках

        previousTransfers = pay + previousTransfers

        var total = toPay(pay = pay, previousTransfers = previousTransfers, card = card)

        assertEquals(
            "Вы переводите 7500001 , у вас карта: Мир : Вы превысили суточный лимит ",
            total
        )
    }

    @Test
    fun toPay_visa() {
        var card = "Visa"   //тип карты

        var previousTransfers = 0  //сумма прошлого платежа в копейках

        var pay = 7500001 //сумма платежа в копейках

        previousTransfers = pay + previousTransfers

        var total = toPay(pay = pay, previousTransfers = previousTransfers, card = card)

        assertEquals(
            "Вы переводите 7500001 , у вас карта: Visa : Вы превысили суточный лимит ",
            total
        )
    }

    @Test
    fun toPay_VkPay() {
        var card = "VK Pay"   //тип карты

        var previousTransfers = 0  //сумма прошлого платежа в копейках

        var pay = 15005 //сумма платежа в копейках

        previousTransfers = pay + previousTransfers

        var total = toPay(pay = pay, previousTransfers = previousTransfers, card = card)

        assertEquals(
            "Вы переводите 15005 , у вас карта: VK Pay : У вас нет комиссии  ",
            total
        )
    }

    @Test
    fun toPay_VkPayLim() {
        var card = "VK Pay"   //тип карты

        var previousTransfers = 0  //сумма прошлого платежа в копейках

        var pay = 1_500_0000//сумма платежа в копейках

        previousTransfers = pay + previousTransfers

        var total = toPay(pay = pay, previousTransfers = previousTransfers, card = card)

        assertEquals(
            "Вы переводите 15000000 , у вас карта: VK Pay : Вы превысили суточный лимит  ",
            total
        )
    }

    @Test
    fun check_shopld() {
        var card = "Maestro"   //тип карты

        var previousTransfers = 15_000  //сумма прошлого платежа в копейках

        var pay = 1500500 //сумма платежа в копейках

        previousTransfers = pay + previousTransfers

        var total = check(pay, previousTransfers, card)

        assertEquals(
            "11253.75",
            total
        )


    }

    @Test
    fun minimumComission_shopld() {

        var previousTransfers = 3500  //сумма прошлого платежа в копейках

        var pay = 1500500 //сумма платежа в копейках

        var total = minimumComission(pay, previousTransfers)

        assertEquals(
            "11253.75",
            total
        )
    }

    @Test
    fun toPayMasterCardAndMaestro_shopld_() {
        var card = "Maestro"   //тип карты

        var previousTransfers = 15_000  //сумма прошлого платежа в копейках

        var pay = 1500500 //сумма платежа в копейках

        previousTransfers = pay + previousTransfers

        var total = toPayMasterCardAndMaestro(pay, previousTransfers)
        assertEquals(
            "Комиссии нет",
            total
        )

    }

    @Test
    fun toPayMasterCardAndMaestro_should() {
        var pay = 75000111
        var check = 0
        var total = toPayMasterCardAndMaestro(pay, check)
        assertEquals(
            "ваша комиссия 44980.06",
            total
        )


    }

    @Test
    fun toPay_shouldd() {
        var card = "Visa"   //тип карты

        var previousTransfers = 1555000  //сумма прошлого платежа в копейках

        var pay = 43256658 //сумма платежа в копейках

        previousTransfers = pay + previousTransfers

        var total = toPay(pay = pay, previousTransfers = previousTransfers, card = card)

        assertEquals(
            "Вы переводите 43256658 , у вас карта: Visa : Вы превысили суточный лимит ",
            total
        )
    }

    @Test
    fun payCommission_should() {
        var pay = 200000

        var total = payCommission(pay)
        assertEquals(
            100.0,
            total
        )

    }


}
