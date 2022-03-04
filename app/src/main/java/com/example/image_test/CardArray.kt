package com.example.image_test

import android.util.Log
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

var returnStringGlobal = ""
var noAceNoPair = false
var cheatWithTheCards = false
var numberOfDecks = 2

class CardArray {

    var deckCardValue = mutableListOf<CardNameValue>()

    var deckOfCards = ArrayList<String>()

    var deckOfCardsInt = ArrayList<Int>()

    var deckOfCardsValue = ArrayList<Int>()

    var shuffled = false
    var iteration = 0
    var iterationInt = 0
    var iterationIntValue = 0
    val numberOfCards = 52*numberOfDecks

 //   var cardNameValue = CardNameValue()

    // H = Hit,  S = Stand,  P = Split,  DD = Double Down

    // initialize deck
    fun initializeDeckOfCards() {

        if(!shuffled) {
            deckOfCards = ArrayList(mutableListOf("clubs_2", "clubs_3", "clubs_4", "clubs_5", "clubs_6", "clubs_7", "clubs_8", "clubs_9", "clubs_10", "clubs_jack", "clubs_queen", "clubs_king", "clubs_ace", "diamonds_2", "diamonds_3", "diamonds_4", "diamonds_5", "diamonds_6", "diamonds_7", "diamonds_8", "diamonds_9", "diamonds_10", "diamonds_jack", "diamonds_queen", "diamonds_king", "diamonds_ace", "hearts_2", "hearts_3", "hearts_4", "hearts_5", "hearts_6", "hearts_7", "hearts_8", "hearts_9", "hearts_10", "hearts_jack", "hearts_queen", "hearts_king", "hearts_ace", "spades_2", "spades_3", "spades_4", "spades_5", "spades_6", "spades_7", "spades_8", "spades_9", "spades_10", "spades_jack", "spades_queen", "spades_king", "spades_ace"))

            deckOfCardsInt = ArrayList(mutableListOf(R.drawable.clubs_2,R.drawable.clubs_3,R.drawable.clubs_4,R.drawable.clubs_5, R.drawable.clubs_6,R.drawable.clubs_7,R.drawable.clubs_8,R.drawable.clubs_9,R.drawable.clubs_9_10,R.drawable.clubs_9_11,R.drawable.clubs_9_12,R.drawable.clubs_9_13,R.drawable.clubs_ace,R.drawable.diamonds_2,R.drawable.diamonds_3,R.drawable.diamonds_4,R.drawable.diamonds_5, R.drawable.diamonds_6,R.drawable.diamonds_7,R.drawable.diamonds_8,R.drawable.diamonds_9,R.drawable.diamonds_9_10,R.drawable.diamonds_9_11,R.drawable.diamonds_9_12,R.drawable.diamonds_9_13,R.drawable.diamonds_ace,R.drawable.hearts_2,R.drawable.hearts_3,R.drawable.hearts_4,R.drawable.hearts_5, R.drawable.hearts_6,R.drawable.hearts_7,R.drawable.hearts_8,R.drawable.hearts_9,R.drawable.hearts_9_10,R.drawable.hearts_9_11,R.drawable.hearts_9_12,R.drawable.hearts_9_13,R.drawable.hearts_ace,R.drawable.spades_2,R.drawable.spades_3,R.drawable.spades_4,R.drawable.spades_5, R.drawable.spades_6,R.drawable.spades_7,R.drawable.spades_8,R.drawable.spades_9,R.drawable.spades_9_10,R.drawable.spades_9_11,R.drawable.spades_9_12,R.drawable.spades_9_13,R.drawable.spades_ace))
            deckOfCardsValue = ArrayList(mutableListOf(2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,11))

            // jag skapar en fuskkortlek
            if (cheatWithTheCards)
            {
                // sju ess, 10, 10
            deckOfCardsInt = ArrayList(mutableListOf(R.drawable.clubs_ace,R.drawable.clubs_ace,R.drawable.clubs_ace,R.drawable.clubs_ace, R.drawable.clubs_ace,R.drawable.clubs_ace,R.drawable.clubs_ace,R.drawable.clubs_9_10,R.drawable.clubs_9_10,R.drawable.clubs_9_11,R.drawable.clubs_9_12,R.drawable.clubs_9_13,R.drawable.clubs_ace,R.drawable.diamonds_2,R.drawable.diamonds_3,R.drawable.diamonds_4,R.drawable.diamonds_5, R.drawable.diamonds_6,R.drawable.diamonds_7,R.drawable.diamonds_8,R.drawable.diamonds_9,R.drawable.diamonds_9_10,R.drawable.diamonds_9_11,R.drawable.diamonds_9_12,R.drawable.diamonds_9_13,R.drawable.diamonds_ace,R.drawable.hearts_2,R.drawable.hearts_3,R.drawable.hearts_4,R.drawable.hearts_5, R.drawable.hearts_6,R.drawable.hearts_7,R.drawable.hearts_8,R.drawable.hearts_9,R.drawable.hearts_9_10,R.drawable.hearts_9_11,R.drawable.hearts_9_12,R.drawable.hearts_9_13,R.drawable.hearts_ace,R.drawable.spades_2,R.drawable.spades_3,R.drawable.spades_4,R.drawable.spades_5, R.drawable.spades_6,R.drawable.spades_7,R.drawable.spades_8,R.drawable.spades_9,R.drawable.spades_9_10,R.drawable.spades_9_11,R.drawable.spades_9_12,R.drawable.spades_9_13,R.drawable.spades_ace))

                // elva ess, 10, 10
                deckOfCardsInt = ArrayList(mutableListOf(R.drawable.clubs_ace,R.drawable.clubs_ace,R.drawable.clubs_ace,R.drawable.clubs_ace, R.drawable.clubs_ace,R.drawable.clubs_ace,R.drawable.clubs_ace,R.drawable.clubs_ace,R.drawable.clubs_ace,R.drawable.clubs_ace,R.drawable.clubs_ace,R.drawable.clubs_9_13,R.drawable.clubs_ace,R.drawable.diamonds_2,R.drawable.diamonds_3,R.drawable.diamonds_4,R.drawable.diamonds_5, R.drawable.diamonds_6,R.drawable.diamonds_7,R.drawable.diamonds_8,R.drawable.diamonds_9,R.drawable.diamonds_9_10,R.drawable.diamonds_9_11,R.drawable.diamonds_9_12,R.drawable.diamonds_9_13,R.drawable.diamonds_ace,R.drawable.hearts_2,R.drawable.hearts_3,R.drawable.hearts_4,R.drawable.hearts_5, R.drawable.hearts_6,R.drawable.hearts_7,R.drawable.hearts_8,R.drawable.hearts_9,R.drawable.hearts_9_10,R.drawable.hearts_9_11,R.drawable.hearts_9_12,R.drawable.hearts_9_13,R.drawable.hearts_ace,R.drawable.spades_2,R.drawable.spades_3,R.drawable.spades_4,R.drawable.spades_5, R.drawable.spades_6,R.drawable.spades_7,R.drawable.spades_8,R.drawable.spades_9,R.drawable.spades_9_10,R.drawable.spades_9_11,R.drawable.spades_9_12,R.drawable.spades_9_13,R.drawable.spades_ace))

                // sju ess, 10, 10
                deckOfCardsValue = ArrayList(mutableListOf(11,11,11,11,11,11,11,10,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,11))

                // elva ess, 10, 10
                deckOfCardsValue = ArrayList(mutableListOf(11,11,11,11,11,11,11,11,11,11,11,10,11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,11))

                //
                deckOfCardsInt = ArrayList(mutableListOf(R.drawable.clubs_9,R.drawable.clubs_9,R.drawable.clubs_ace,R.drawable.clubs_6, R.drawable.clubs_3,R.drawable.clubs_8,R.drawable.clubs_7,R.drawable.clubs_9_10,R.drawable.clubs_ace,R.drawable.clubs_ace,R.drawable.clubs_ace,R.drawable.clubs_9_13,R.drawable.clubs_ace,R.drawable.diamonds_2,R.drawable.diamonds_3,R.drawable.diamonds_4,R.drawable.diamonds_5, R.drawable.diamonds_6,R.drawable.diamonds_7,R.drawable.diamonds_8,R.drawable.diamonds_9,R.drawable.diamonds_9_10,R.drawable.diamonds_9_11,R.drawable.diamonds_9_12,R.drawable.diamonds_9_13,R.drawable.diamonds_ace,R.drawable.hearts_2,R.drawable.hearts_3,R.drawable.hearts_4,R.drawable.hearts_5, R.drawable.hearts_6,R.drawable.hearts_7,R.drawable.hearts_8,R.drawable.hearts_9,R.drawable.hearts_9_10,R.drawable.hearts_9_11,R.drawable.hearts_9_12,R.drawable.hearts_9_13,R.drawable.hearts_ace,R.drawable.spades_2,R.drawable.spades_3,R.drawable.spades_4,R.drawable.spades_5, R.drawable.spades_6,R.drawable.spades_7,R.drawable.spades_8,R.drawable.spades_9,R.drawable.spades_9_10,R.drawable.spades_9_11,R.drawable.spades_9_12,R.drawable.spades_9_13,R.drawable.spades_ace))

                //
                deckOfCardsValue = ArrayList(mutableListOf(9,9,11,6,3,8,7,10,11,11,11,10,11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,11))

                //
                deckOfCardsInt = ArrayList(mutableListOf(R.drawable.clubs_9_10,R.drawable.clubs_9_10,R.drawable.clubs_9_10,R.drawable.clubs_9_10, R.drawable.clubs_ace,R.drawable.clubs_2,R.drawable.clubs_3,R.drawable.clubs_4,R.drawable.clubs_ace,R.drawable.clubs_ace,R.drawable.clubs_ace,R.drawable.clubs_9_13,R.drawable.clubs_ace,R.drawable.diamonds_2,R.drawable.diamonds_3,R.drawable.diamonds_4,R.drawable.diamonds_5, R.drawable.diamonds_6,R.drawable.diamonds_7,R.drawable.diamonds_8,R.drawable.diamonds_9,R.drawable.diamonds_9_10,R.drawable.diamonds_9_11,R.drawable.diamonds_9_12,R.drawable.diamonds_9_13,R.drawable.diamonds_ace,R.drawable.hearts_2,R.drawable.hearts_3,R.drawable.hearts_4,R.drawable.hearts_5, R.drawable.hearts_6,R.drawable.hearts_7,R.drawable.hearts_8,R.drawable.hearts_9,R.drawable.hearts_9_10,R.drawable.hearts_9_11,R.drawable.hearts_9_12,R.drawable.hearts_9_13,R.drawable.hearts_ace,R.drawable.spades_2,R.drawable.spades_3,R.drawable.spades_4,R.drawable.spades_5, R.drawable.spades_6,R.drawable.spades_7,R.drawable.spades_8,R.drawable.spades_9,R.drawable.spades_9_10,R.drawable.spades_9_11,R.drawable.spades_9_12,R.drawable.spades_9_13,R.drawable.spades_ace))

                //
                deckOfCardsValue = ArrayList(mutableListOf(10,10,10,10,11,2,3,4,11,11,11,10,11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,11))

                //
                deckOfCardsInt = ArrayList(mutableListOf(R.drawable.clubs_ace,R.drawable.clubs_ace,R.drawable.clubs_ace,R.drawable.clubs_ace, R.drawable.clubs_9_10,R.drawable.clubs_2,R.drawable.clubs_3,R.drawable.clubs_4,R.drawable.clubs_ace,R.drawable.clubs_ace,R.drawable.clubs_ace,R.drawable.clubs_9_13,R.drawable.clubs_ace,R.drawable.diamonds_2,R.drawable.diamonds_3,R.drawable.diamonds_4,R.drawable.diamonds_5, R.drawable.diamonds_6,R.drawable.diamonds_7,R.drawable.diamonds_8,R.drawable.diamonds_9,R.drawable.diamonds_9_10,R.drawable.diamonds_9_11,R.drawable.diamonds_9_12,R.drawable.diamonds_9_13,R.drawable.diamonds_ace,R.drawable.hearts_2,R.drawable.hearts_3,R.drawable.hearts_4,R.drawable.hearts_5, R.drawable.hearts_6,R.drawable.hearts_7,R.drawable.hearts_8,R.drawable.hearts_9,R.drawable.hearts_9_10,R.drawable.hearts_9_11,R.drawable.hearts_9_12,R.drawable.hearts_9_13,R.drawable.hearts_ace,R.drawable.spades_2,R.drawable.spades_3,R.drawable.spades_4,R.drawable.spades_5, R.drawable.spades_6,R.drawable.spades_7,R.drawable.spades_8,R.drawable.spades_9,R.drawable.spades_9_10,R.drawable.spades_9_11,R.drawable.spades_9_12,R.drawable.spades_9_13,R.drawable.spades_ace))

                //
                deckOfCardsValue = ArrayList(mutableListOf(11,11,11,11,10,2,3,4,11,11,11,10,11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,11))

                deckOfCardsInt = ArrayList(mutableListOf(R.drawable.clubs_ace,R.drawable.clubs_2,R.drawable.clubs_ace,R.drawable.clubs_4, R.drawable.clubs_5,R.drawable.clubs_2,R.drawable.clubs_9_10,R.drawable.clubs_4,R.drawable.clubs_ace,R.drawable.clubs_ace,R.drawable.clubs_ace,R.drawable.clubs_9_13,R.drawable.clubs_ace,R.drawable.diamonds_2,R.drawable.diamonds_3,R.drawable.diamonds_4,R.drawable.diamonds_5, R.drawable.diamonds_6,R.drawable.diamonds_7,R.drawable.diamonds_8,R.drawable.diamonds_9,R.drawable.diamonds_9_10,R.drawable.diamonds_9_11,R.drawable.diamonds_9_12,R.drawable.diamonds_9_13,R.drawable.diamonds_ace,R.drawable.hearts_2,R.drawable.hearts_3,R.drawable.hearts_4,R.drawable.hearts_5, R.drawable.hearts_6,R.drawable.hearts_7,R.drawable.hearts_8,R.drawable.hearts_9,R.drawable.hearts_9_10,R.drawable.hearts_9_11,R.drawable.hearts_9_12,R.drawable.hearts_9_13,R.drawable.hearts_ace,R.drawable.spades_2,R.drawable.spades_3,R.drawable.spades_4,R.drawable.spades_5, R.drawable.spades_6,R.drawable.spades_7,R.drawable.spades_8,R.drawable.spades_9,R.drawable.spades_9_10,R.drawable.spades_9_11,R.drawable.spades_9_12,R.drawable.spades_9_13,R.drawable.spades_ace))

                //
                deckOfCardsValue = ArrayList(mutableListOf(11,2,11,4,5,2,10,4,11,11,11,10,11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,11))


                deckOfCardsInt = ArrayList(mutableListOf(R.drawable.clubs_ace,R.drawable.clubs_ace,R.drawable.clubs_ace,R.drawable.clubs_9_10, R.drawable.clubs_9_10,R.drawable.clubs_9_10,R.drawable.clubs_9_10,R.drawable.clubs_4,R.drawable.clubs_ace,R.drawable.clubs_ace,R.drawable.clubs_9_10,R.drawable.clubs_ace,R.drawable.clubs_ace,R.drawable.diamonds_2,R.drawable.diamonds_3,R.drawable.diamonds_4,R.drawable.diamonds_5, R.drawable.diamonds_6,R.drawable.diamonds_7,R.drawable.diamonds_8,R.drawable.diamonds_9,R.drawable.diamonds_9_10,R.drawable.diamonds_9_11,R.drawable.diamonds_9_12,R.drawable.diamonds_9_13,R.drawable.diamonds_ace,R.drawable.hearts_2,R.drawable.hearts_3,R.drawable.hearts_4,R.drawable.hearts_5, R.drawable.hearts_6,R.drawable.hearts_7,R.drawable.hearts_8,R.drawable.hearts_9,R.drawable.hearts_9_10,R.drawable.hearts_9_11,R.drawable.hearts_9_12,R.drawable.hearts_9_13,R.drawable.hearts_ace,R.drawable.spades_2,R.drawable.spades_3,R.drawable.spades_4,R.drawable.spades_5, R.drawable.spades_6,R.drawable.spades_7,R.drawable.spades_8,R.drawable.spades_9,R.drawable.spades_9_10,R.drawable.spades_9_11,R.drawable.spades_9_12,R.drawable.spades_9_13,R.drawable.spades_ace))

                //
                deckOfCardsValue = ArrayList(mutableListOf(11,11,11,10,10,10,10,4,11,11,11,10,11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,11))


                deckOfCardsInt = ArrayList(mutableListOf(R.drawable.clubs_ace,R.drawable.clubs_ace,R.drawable.clubs_9_10,R.drawable.clubs_9, R.drawable.clubs_9,R.drawable.clubs_3,R.drawable.clubs_3,R.drawable.clubs_3,R.drawable.clubs_3,R.drawable.clubs_3,R.drawable.clubs_4,R.drawable.clubs_ace,R.drawable.clubs_6,R.drawable.diamonds_2,R.drawable.diamonds_3,R.drawable.diamonds_4,R.drawable.diamonds_5, R.drawable.diamonds_6,R.drawable.diamonds_7,R.drawable.diamonds_8,R.drawable.diamonds_9,R.drawable.diamonds_9_10,R.drawable.diamonds_9_11,R.drawable.diamonds_9_12,R.drawable.diamonds_9_13,R.drawable.diamonds_ace,R.drawable.hearts_2,R.drawable.hearts_3,R.drawable.hearts_4,R.drawable.hearts_5, R.drawable.hearts_6,R.drawable.hearts_7,R.drawable.hearts_8,R.drawable.hearts_9,R.drawable.hearts_9_10,R.drawable.hearts_9_11,R.drawable.hearts_9_12,R.drawable.hearts_9_13,R.drawable.hearts_ace,R.drawable.spades_2,R.drawable.spades_3,R.drawable.spades_4,R.drawable.spades_5, R.drawable.spades_6,R.drawable.spades_7,R.drawable.spades_8,R.drawable.spades_9,R.drawable.spades_9_10,R.drawable.spades_9_11,R.drawable.spades_9_12,R.drawable.spades_9_13,R.drawable.spades_ace))

                //
                deckOfCardsValue = ArrayList(mutableListOf(11,11,10,9,9,3,3,3,3,3,3,11,6,2,3,4,11,6,6,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,11))

            }



for (j in 0..numberOfDecks-1) {
    // varför har det betydelse att jag flyttar denna, pekare ?         var cardNameValueTemp = CardNameValue()
    for (i in 0..51) {
        var cardNameValueTemp = CardNameValue()
        cardNameValueTemp.name = deckOfCardsInt[i]
        cardNameValueTemp.value = deckOfCardsValue[i]

        deckCardValue.add(cardNameValueTemp)
    }
}
 /*           for (i in 0..51){
                var cardNameValueTemp = CardNameValue()
                cardNameValueTemp.name = deckOfCardsInt[i]
                cardNameValueTemp.value = deckOfCardsValue[i]


                deckCardValue.add(cardNameValueTemp)
            }
            for (i in 0..51){
                var cardNameValueTemp = CardNameValue()
                cardNameValueTemp.name = deckOfCardsInt[i]
                cardNameValueTemp.value = deckOfCardsValue[i]


                deckCardValue.add(cardNameValueTemp)
            }*/

     //       deckCardValue.shuffle()
            for (i in 0..51)
            {
                Log.i("här kommer imagenumber ", "hej hopp " + deckCardValue[i].name.toString())
                Log.i("här kommer value ", "hej hopp " + deckCardValue[i].value.toString())
            }

            if (!cheatWithTheCards)
            {
                deckCardValue.shuffle()
            }

    /*        for (i in 0..10) {
                var cardNameValue = CardNameValue()

                cardNameValue.name = i
                cardNameValue.value = i
                testa.add(cardNameValue)

            }*/

       //     deckOfCardsInt = ArrayList(mutableListOf(R.drawable.clubs_3))
       /*     for (i in 1..51){
                deckOfCardsInt.add(R.drawable.clubs_3+i)
            }*/

       /*     deckOfCardsInt.add(R.drawable.clubs_2+2)
            deckOfCardsInt.add(R.drawable.clubs_2+3)
            deckOfCardsInt.add(R.drawable.clubs_2+4)
            deckOfCardsInt.add(R.drawable.clubs_2+5)
            deckOfCardsInt.add(R.drawable.clubs_2+6)
            deckOfCardsInt.add(R.drawable.clubs_2+7)*/

      //      deckOfCardsInt.shuffle()

            deckOfCards.shuffle()
            shuffled = true
        }
    }
    // get card list
    fun getFourRandomCards_anvander_vi_denna(): ArrayList<String> {
        var cardList = ArrayList<String>()

        Log.i("size", "getFourRandomCards ")
        if(iteration < numberOfCards) {
            cardList.add(deckOfCards[iteration])
            cardList.add(deckOfCards[++iteration])
            cardList.add(deckOfCards[++iteration])
            cardList.add(deckOfCards[++iteration])

            iteration++
        }

        return cardList
    }
    fun getOneRandomCardsInt_anvander_vi_denna(): ArrayList<Int> {

        var cardListInt = ArrayList<Int>()
        Log.i("size", "getOneRandomCardsInt ")
        if(iterationInt < numberOfCards) {

            cardListInt.add(deckOfCardsInt[iterationInt])

            iterationInt++
        }
        else
        {
            Log.i("size", "getOneRandomCardsInt more ")
        }

        return cardListInt
    }

    fun getOneRandomCardsValue(): ArrayList<CardNameValue> {

        var cardListIntValue = ArrayList<CardNameValue>()
        Log.i("size", "getOneRandomCardsValue ")
        if(iterationIntValue < numberOfCards) {

            cardListIntValue.add(deckCardValue[iterationIntValue])

            iterationIntValue++
        }
        else
        {
            iterationIntValue = 0

            shuffled = false
            initializeDeckOfCards()

            cardListIntValue.add(deckCardValue[iterationIntValue])
            iterationIntValue++

            Log.i("size", "getOneRandomCardsValueMore ")
        }

        return cardListIntValue
    }

    fun checkStrategy2(playerCard1 : Int, playerCard2: Int, dealerCard : Int, playerCardSum: Int)
    {

        return
    }


    fun checkStrategy(playerCard1 : Int, playerCard2: Int, dealerCard : Int, playerCardSum: Int)
    {
        var strategy_5_8 = ArrayList(mutableListOf("H","H","H","H","H","H","H","H","H","H"))
        var strategy_9 = ArrayList(mutableListOf("DD","DD","DD","DD","DD","H","H","H","H","H"))
        var strategy_10 = ArrayList(mutableListOf("DD","DD","DD","DD","DD","DD","DD","DD","H","H"))
        var strategy_11 = ArrayList(mutableListOf("DD","DD","DD","DD","DD","DD","DD","DD","DD","DD"))

        var strategy_12 = ArrayList(mutableListOf("H","H","S","S","S","H","H","H","H","H"))
        var strategy_13 = ArrayList(mutableListOf("S","S","S","S","S","H","H","H","H","H"))
        var strategy_14 = ArrayList(mutableListOf("S","S","S","S","S","H","H","H","H","H"))
        var strategy_15 = ArrayList(mutableListOf("S","S","S","S","S","H","H","H","H","H"))
        var strategy_16 = ArrayList(mutableListOf("S","S","S","S","S","H","H","H","H","H"))
        var strategy_17 = ArrayList(mutableListOf("S","S","S","S","S","S","S","S","S","S"))
        var strategy_18 = ArrayList(mutableListOf("S","S","S","S","S","S","S","S","S","S"))
        var strategy_19 = ArrayList(mutableListOf("S","S","S","S","S","S","S","S","S","S"))
        var strategy_20 = ArrayList(mutableListOf("S","S","S","S","S","S","S","S","S","S"))
        var strategy_21 = ArrayList(mutableListOf("S","S","S","S","S","S","S","S","S","S"))

        var strategy_A_2 = ArrayList(mutableListOf("H","H","H","DD","DD","H","H","H","H","H"))
        var strategy_A_3 = ArrayList(mutableListOf("H","H","H","DD","DD","H","H","H","H","H"))
        var strategy_A_4 = ArrayList(mutableListOf("H","H","DD","DD","DD","H","H","H","H","H"))
        var strategy_A_5 = ArrayList(mutableListOf("H","H","DD","DD","DD","H","H","H","H","H"))
        var strategy_A_6 = ArrayList(mutableListOf("H","DD","DD","DD","DD","H","H","H","H","H"))
        var strategy_A_7 = ArrayList(mutableListOf("S","DD","DD","DD","DD","S","S","H","H","H"))
        var strategy_A_8 = ArrayList(mutableListOf("S","S","S","S","DD","S","S","S","S","S"))
        var strategy_A_9 = ArrayList(mutableListOf("S","S","S","S","S","S","S","S","S","S"))
        var strategy_A_10 = ArrayList(mutableListOf("S","S","S","S","S","S","S","S","S","S"))

        var strategy_2_2 = ArrayList(mutableListOf("H","H","SP","SP","SP","SP","H","H","H","H"))
        var strategy_3_3 = ArrayList(mutableListOf("H","H","SP","SP","SP","SP","H","H","H","H"))
        var strategy_4_4 = ArrayList(mutableListOf("H","H","H","H","H","H","H","H","H","H"))
        var strategy_5_5 = ArrayList(mutableListOf("DD","DD","DD","DD","DD","DD","DD","DD","H","H"))
        var strategy_6_6 = ArrayList(mutableListOf("H","SP","SP","SP","SP","H","H","H","H","H"))
        var strategy_7_7 = ArrayList(mutableListOf("SP","SP","SP","SP","SP","SP","H","H","H","H"))
        var strategy_8_8 = ArrayList(mutableListOf("SP","SP","SP","SP","SP","SP","SP","SP","SP","SP"))
        var strategy_9_9 = ArrayList(mutableListOf("SP","SP","SP","SP","SP","S","SP","SP","S","S"))
        var strategy_10_10 = ArrayList(mutableListOf("S","S","S","S","S","S","S","S","S","S"))
        var strategy_A_A = ArrayList(mutableListOf("SP","SP","SP","SP","SP","SP","SP","SP","SP","SP"))

        var returnString = ""

        var playerCard1_Here = playerCard1
        var playerCard2_Here = playerCard2
        var sum = playerCard1_Here + playerCard2_Here


        // Makes it more easy below
        if (playerCard1_Here < playerCard2_Here)
        {
            var tempCard = playerCard1_Here
            playerCard1_Here = playerCard2_Here
            playerCard2_Here = tempCard
        }

        if (playerCardSum == 0) {
            // This takes care of the pairs
            if (playerCard1_Here == playerCard2_Here) {
                when (playerCard1_Here) {
                    2 -> {
                        returnString = strategy_2_2[dealerCard - 2]
                    }
                    3 -> {
                        returnString = strategy_3_3[dealerCard - 2]
                    }
                    4 -> {
                        returnString = strategy_4_4[dealerCard - 2]
                    }
                    5 -> {
                        returnString = strategy_5_5[dealerCard - 2]
                    }
                    6 -> {
                        returnString = strategy_6_6[dealerCard - 2]
                    }
                    7 -> {
                        returnString = strategy_7_7[dealerCard - 2]
                    }
                    8 -> {
                        returnString = strategy_8_8[dealerCard - 2]
                    }
                    9 -> {
                        returnString = strategy_9_9[dealerCard - 2]
                    }
                    10 -> {
                        returnString = strategy_10_10[dealerCard - 2]
                    }
                    11 -> {
                        returnString = strategy_A_A[dealerCard - 2]
                    }
                    else -> {

                    }
                }

                Log.i("DoThis ", returnString)
                returnStringGlobal = returnString
                return
            }

            // if there was an ace 11, it is now playercard1
            if (playerCard1_Here == 11) {
                when (playerCard2_Here)
                {
                    2 -> {
                        returnString = strategy_A_2[dealerCard - 2]
                    }
                    3 -> {
                        returnString = strategy_A_3[dealerCard - 2]
                    }
                    4 -> {
                        returnString = strategy_A_4[dealerCard - 2]
                    }
                    5 -> {
                        returnString = strategy_A_5[dealerCard - 2]
                    }
                    6 -> {
                        returnString = strategy_A_6[dealerCard - 2]
                    }
                    7 -> {
                        returnString = strategy_A_7[dealerCard - 2]
                    }
                    8 -> {
                        returnString = strategy_A_8[dealerCard - 2]
                    }
                    9 -> {
                        returnString = strategy_A_9[dealerCard - 2]
                    }
                    10 -> {
                        returnString = strategy_A_10[dealerCard - 2]
                    }

                    else -> {

                    }
                }

                Log.i("DoThis ", returnString)
                returnStringGlobal = returnString
                return
            }

            when(sum)
            {
                5 -> {
                    returnString = strategy_5_8[dealerCard - 2]
                }
                6 -> {
                    returnString = strategy_5_8[dealerCard - 2]
                }
                7 -> {
                    returnString = strategy_5_8[dealerCard - 2]
                }
                8 -> {
                    returnString = strategy_5_8[dealerCard - 2]
                }
                9 -> {
                    returnString = strategy_9[dealerCard - 2]
                }
                10 -> {
                    returnString = strategy_10[dealerCard - 2]
                }
                11 -> {
                    returnString = strategy_11[dealerCard - 2]
                }
                12 -> {
                    returnString = strategy_12[dealerCard - 2]
                }
                13 -> {
                    returnString = strategy_13[dealerCard - 2]
                }
                14 -> {
                    returnString = strategy_14[dealerCard - 2]
                }
                15 -> {
                    returnString = strategy_15[dealerCard - 2]
                }
                16 -> {
                    returnString = strategy_16[dealerCard - 2]
                }
                17 -> {
                    returnString = strategy_17[dealerCard - 2]
                }
                18 -> {
                    returnString = strategy_18[dealerCard - 2]
                }
                19 -> {
                    returnString = strategy_19[dealerCard - 2]
                }
                20 -> {
                    returnString = strategy_20[dealerCard - 2]
                }
                21 -> {
                    returnString = strategy_21[dealerCard - 2]
                }
                else -> {

                }
            }
            Log.i("DoThis ", returnString)
            returnStringGlobal = returnString
            return
        }

// if we reach this, then there is no ace 11 and it is not a pair. So we check the sum
        if (playerCardSum != 0){
            sum = playerCardSum
        }
        noAceNoPair = true
            when(sum){
                5 -> {
                    returnString = strategy_5_8[dealerCard-2]
                }
                6 -> {
                    returnString = strategy_5_8[dealerCard-2]
                }
                7 -> {
                    returnString = strategy_5_8[dealerCard-2]
                }
                8 -> {
                    returnString = strategy_5_8[dealerCard-2]
                }
                9 -> { // double only possible with 2 cards
                    returnString = strategy_5_8[dealerCard-2]
                }
                10 -> { // double only possible with 2 cards
                    returnString = strategy_5_8[dealerCard-2]
                }
                11 -> { // double only possible with 2 cards
                    returnString = strategy_5_8[dealerCard-2]
                }
                12 -> {
                    returnString = strategy_12[dealerCard-2]
                }
                13 -> {
                    returnString = strategy_13[dealerCard-2]
                }
                14 -> {
                    returnString = strategy_14[dealerCard-2]
                }
                15 -> {
                    returnString = strategy_15[dealerCard-2]
                }
                16 -> {
                    returnString = strategy_16[dealerCard-2]
                }
                17 -> {
                    returnString = strategy_17[dealerCard-2]
                }
                18 -> {
                    returnString = strategy_18[dealerCard-2]
                }
                19 -> {
                    returnString = strategy_19[dealerCard-2]
                }
                20 -> {
                    returnString = strategy_20[dealerCard-2]
                }
                21 -> {
                    returnString = strategy_21[dealerCard-2]
                }
                else -> {

                }
            }

            Log.i("DoThis ", returnString)
            returnStringGlobal = returnString
            return
    }

    fun checkOne()
    {
        // Start test if we have a card with same value
               Log.i("DoThis ", "---------------------------")
               for (i in 2..11) {
                   checkStrategy(2, 2, i,0)
               }
               Log.i("DoThis ", "---------------------------")
               for (i in 2..11) {
                   checkStrategy(3, 3, i,0)
               }
               Log.i("DoThis ", "---------------------------")
               for (i in 2..11) {
                   checkStrategy(4, 4, i,0)
               }
               Log.i("DoThis ", "---------------------------")
               for (i in 2..11) {
                   checkStrategy(5, 5, i,0)
               }
               Log.i("DoThis ", "---------------------------")
               for (i in 2..11) {
                   checkStrategy(6, 6, i,0)
               }
               Log.i("DoThis ", "---------------------------")
               for (i in 2..11) {
                   checkStrategy(7, 7, i,0)
               }
               Log.i("DoThis ", "---------------------------")
               for (i in 2..11) {
                   checkStrategy(8, 8, i,0)
               }
               Log.i("DoThis ", "---------------------------")
               for (i in 2..11) {
                   checkStrategy(9, 9, i,0)
               }
               Log.i("DoThis ", "---------------------------")
               for (i in 2..11) {
                   checkStrategy(10, 10, i,0)
               }
               Log.i("DoThis ", "---------------------------")
               for (i in 2..11) {
                   checkStrategy(11, 11, i,0)
               }
               Log.i("DoThis ", "---------------------------")

    }

    fun checkTwo()
    {
        // Start test if we have first card value 11
              for (i in 2..11) {
                  checkStrategy(11, 2, i,0)
              }
              Log.i("DoThis ", "---------------------------")
              for (i in 2..11) {
                  checkStrategy(11, 3, i,0)
              }
              Log.i("DoThis ", "---------------------------")
              for (i in 2..11) {
                  checkStrategy(11, 4, i,0)
              }
              Log.i("DoThis ", "---------------------------")
              for (i in 2..11) {
                  checkStrategy(11, 5, i,0)
              }
              Log.i("DoThis ", "---------------------------")
              for (i in 2..11) {
                  checkStrategy(11, 6, i,0)
              }
              Log.i("DoThis ", "---------------------------")
              for (i in 2..11) {
                  checkStrategy(11, 7, i,0)
              }
              Log.i("DoThis ", "---------------------------")
              for (i in 2..11) {
                  checkStrategy(11, 8, i,0)
              }
              Log.i("DoThis ", "---------------------------")
              for (i in 2..11) {
                  checkStrategy(11, 9, i,0)
              }
              Log.i("DoThis ", "---------------------------")

    }

    fun checkThree()
    {
        // Start test if we have second card value 11
        for (i in 2..11) {
            checkStrategy(2, 11, i,0)
        }
        Log.i("DoThis ", "---------------------------")
        for (i in 2..11) {
            checkStrategy(3, 11, i,0)
        }
        Log.i("DoThis ", "---------------------------")
        for (i in 2..11) {
            checkStrategy(4, 11, i,0)
        }
        Log.i("DoThis ", "---------------------------")
        for (i in 2..11) {
            checkStrategy(5, 11, i,0)
        }
        Log.i("DoThis ", "---------------------------")
        for (i in 2..11) {
            checkStrategy(6, 11, i,0)
        }
        Log.i("DoThis ", "---------------------------")
        for (i in 2..11) {
            checkStrategy(7, 11, i,0)
        }
        Log.i("DoThis ", "---------------------------")
        for (i in 2..11) {
            checkStrategy(8, 11, i,0)
        }
        Log.i("DoThis ", "---------------------------")
        for (i in 2..11) {
            checkStrategy(9, 11, i,0)
        }
        Log.i("DoThis ", "---------------------------")

    }

    fun checkFour()
    {
        // Sum 5-17
        for (i in 2..11) {
            checkStrategy(2, 3, i,0)
        }
        Log.i("DoThis ", "---------------------------")
        for (i in 2..11) {
            checkStrategy(2, 4, i,0)
        }
        Log.i("DoThis ", "---------------------------")
        for (i in 2..11) {
            checkStrategy(2, 5, i,0)
        }
        Log.i("DoThis ", "---------------------------")
        for (i in 2..11) {
            checkStrategy(2, 6, i,0)
        }
        Log.i("DoThis ", "---------------------------")
        for (i in 2..11) {
            checkStrategy(2, 7, i,0)
        }
        Log.i("DoThis ", "---------------------------")
        for (i in 2..11) {
            checkStrategy(2, 8, i,0)
        }
        Log.i("DoThis ", "---------------------------")
        for (i in 2..11) {
            checkStrategy(2, 9, i,0)
        }
        Log.i("DoThis ", "---------------------------")
        for (i in 2..11) {
            checkStrategy(2, 10, i,0)
        }
        Log.i("DoThis ", "---------------------------")
        for (i in 2..11) {
            checkStrategy(10, 3, i,0)
        }
        Log.i("DoThis ", "---------------------------")
        for (i in 2..11) {
            checkStrategy(10, 4, i,0)
        }
        Log.i("DoThis ", "---------------------------")
        for (i in 2..11) {
            checkStrategy(10, 5, i,0)
        }
        Log.i("DoThis ", "---------------------------")
        for (i in 2..11) {
            checkStrategy(10, 6, i,0)
        }
        Log.i("DoThis ", "---------------------------")
        for (i in 2..11) {
            checkStrategy(10, 7, i,0)
        }
        Log.i("DoThis ", "---------------------------")

    }


}

