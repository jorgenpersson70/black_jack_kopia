package com.example.image_test

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.*
import com.google.android.material.snackbar.Snackbar
import java.io.IOException

// They allow doubling for less, as long as the double bet is at least $5. At most casinos, the player
// must stand after splitting aces. The 1992 edition of Basic Blackjack by Stanford Wong also addresses
// this rule, but not the 1995 edition.

//You can find a $3 3:2 double deck game at the world famous Western, and at other luxury casinos.

//There’s only one point in a game of blackjack when you have the opportunity to double down – directly
// after your initial two cards have been dealt.

//Chances are, you had a rule whereby if you collect five cards in your hand without busting, you automatically
//win – unless the dealer has a blackjack
// Pontoons and Five Card Tricks are paid double. … Everyone then exposes their cards and those who have
// 19 or more win, those with Pontoons and Five Card Tricks win double and the rest lose. A dealer who
// makes 21 will be paying Five Card Tricks and Pontoons only.

// A player total of 21 on the first two cards is a « natural » or « blackjack, » and the player wins
// immediately unless dealer also has one, in which case the hand ties. … But a blackjack beats any hand
// that is not a blackjack, even one with a value of 21.

// Each player's basic aim is to form a hand whose total value is as near as possible to 21,
// without going above 21. ... Next best after a Pontoon is a Five Card Trick, which is a hand
// of five cards totaling 21 or less. A hand of three or four cards worth 21 points beats everything
// else except a Pontoon or Five Card Trick.

// https://edge.twinspires.com/casino-news/5-card-charlie-blackjack-rule-a-complete-guide/

/*
An Ace will have a value of 11 unless that would give a player or the dealer a score in
excess of 21; in which case, it has a value of 1. The dealer starts the game. Every player
gets 2 cards, face up. The Dealer's first ace counts as 11 unless it busts the hand.
 */


/*
What Does Double Down Mean in Blackjack? This is another excellent strategy question.
On your original two cards, you can double your bet before the dealer gives you another
card. You place another bet equal to the first. Then, the dealer will give you only one
card The dealer settles all bets at the end of the hand.
 */

/*
// The gesture threshold expressed in dp
private const val GESTURE_THRESHOLD_DP = 16.0f
...
private var mGestureThreshold: Int = 0
...
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    // Get the screen's density scale
    val scale: Float = resources.displayMetrics.density
    // Convert the dps to pixels, based on density scale
    mGestureThreshold = (GESTURE_THRESHOLD_DP * scale + 0.5f).toInt()

    // Use mGestureThreshold as a distance in pixels...
}

*/




var dealerNoMoreCards = 0
var flipCardNumber = 1
var sumplayer = 0
var sumplayer_split = 0
var stack = 0
var playerLeftToMuch = false
var playerRightToMuch = false
var blockclick = true
var blockEveryBtn = false

var coins = 14
var survivedCountDeals = 0
var DoubleActive = false
var weAreInSplit = false
var playerLeftPressedStand = false
var playerLeftBlackJack = false
var playerRightBlackJack = false
var LeftSideDone = false
var RightSideDone = false
var playerLeftHasFiveCards = true
var playerRightHasFiveCards = true
var splitAces = false

var cheat = false

class MainActivity : AppCompatActivity() {
    var cardArray = CardArray()
 // här   var strategy = ShowStrategyPic()

 //   var mGestureThreshold: Int = 0

    //  var flipCardNumber = 1
    var flipDealerCardNumber = 1


    var playerCards_test = mutableListOf<Int>()
    var playerCards_split_test = ArrayList<Int>()
   // var playerCards = ArrayList<Int>()
   var playerCards = mutableListOf<Int>()
    var playerCards_split = ArrayList<Int>()
    var playerCardsName = ArrayList<Int>()

    var dealerCards = ArrayList<Int>()

    // var testa = ArrayList<CardNameValue>()
    var testa = mutableListOf<CardNameValue>()

    var randomCardsIntValue = ArrayList<CardNameValue>()

    var mediaPlayer : MediaPlayer? = null


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //  countdown()
 //       var playerCardLinearLayout = findViewById<LinearLayout>(R.id.playercardLL)

        var splitButton = findViewById<Button>(R.id.splitBtn)
        var cards_Btn = findViewById<Button>(R.id.cardsBtn)
        var stand_Btn = findViewById<Button>(R.id.standBtn)

        var cards2_Btn = findViewById<Button>(R.id.cards2Btn)
        var stand2_Btn = findViewById<Button>(R.id.stand2Btn)

        var newDeal_Btn = findViewById<Button>(R.id.newDealBtn)
        var double_Btn = findViewById<Button>(R.id.doubleBtn)

        var back_side_card = findViewById<ImageView>(R.id.dealercard2)
        var left_down_card1 = findViewById<ImageView>(R.id.leftDownCard1)
        var left_down_card2 = findViewById<ImageView>(R.id.leftDownCard2)

        var right_down_card1 = findViewById<ImageView>(R.id.rightDownCard1)
        var right_down_card2 = findViewById<ImageView>(R.id.rightDownCard2)
        var linearLayoutRight = findViewById<LinearLayout>(R.id.linearLayoutRight)

     //   var left_down_card2 = findViewById<ImageView>(R.id.leftDownCard1)
    //    var right_down_card2 = findViewById<ImageView>(R.id.leftDownCard2)

        var flip_card1 = findViewById<ImageView>(R.id.flipCard1)
        var flip_card2 = findViewById<ImageView>(R.id.flipCard2)
        var flip_card3 = findViewById<ImageView>(R.id.flipCard3)
  //      var flip_card4 = findViewById<ImageView>(R.id.flipCard4)

        var flip_card1_split = findViewById<ImageView>(R.id.flipCard1_split)
        var flip_card2_split = findViewById<ImageView>(R.id.flipCard2_split)
        var flip_card3_split = findViewById<ImageView>(R.id.flipCard3_split)
    //    var flip_card4_split = findViewById<ImageView>(R.id.flipCard4_split)

        var flip_lefttopcard = findViewById<ImageView>(R.id.leftTopCard)
        var flip_dealercard2 = findViewById<ImageView>(R.id.dealercard2)
        var flip_dealercard3 = findViewById<ImageView>(R.id.dealercard3)
        var flip_dealercard4 = findViewById<ImageView>(R.id.dealercard4)
        var flip_dealercard5 = findViewById<ImageView>(R.id.dealercard5)

        var addPlayerCards = findViewById<TextView>(R.id.addUpPlayerHigh)
        var addPlayerCards2 = findViewById<TextView>(R.id.addUpPlayer2High)
        var addPlayerCards2Low = findViewById<TextView>(R.id.addUpPlayer2Low)

   //     var addupdealer1 = findViewById<TextView>(R.id.addUpDealer1)



      //  var addupdealer2 = findViewById<TextView>(R.id.addUpDealer2)

      //  var stackOfCoins = findViewById<TextView>(R.id.stack)


        //
     //   val scale: Float = resources.displayMetrics.density
        //
        //playerCardLinearLayout.size =

    //    stackOfCoins.text = "1000"
        stack = 1000

        //   leftDownCard
        //   rightDownCard
        // shuffle
        cardArray.initializeDeckOfCards()

        var strategyButton = findViewById<Button>(R.id.showStrategyBtn)

        CardStandBtnLeftInvisible()
        splitDoubleBtnInvisible()

      //  Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show()

        playSound(true)
        val snack = Snackbar.make(findViewById(android.R.id.content),"JAG FÖRKLARAR",Snackbar.LENGTH_INDEFINITE)
        snack.setAction("Håll Klaffen !!")
        {
            playSound(false)
        }
        snack.show()

  /*      val snack = Snackbar.make(binding.root, "Inte en siffra", Snackbar.LENGTH_INDEFINITE)
        snack.setAction("Håll Klaffen !!")
        {

        }
        snack.show()*/

        // test. går knappen att klicka om den är INVISIBLE, Bra, den går inte att klicka
       // strategyButton.visibility = View.INVISIBLE

     //   Log.i("scale ", scale.toString())

        // Convert the dps to pixels, based on density scale
    //    mGestureThreshold = (16.0f * scale + 0.5f).toInt()

    //    Log.i("scale ", mGestureThreshold.toString())

        strategyButton.setOnClickListener {
            if (!blockEveryBtn) {
                val intent = Intent(this, ShowStrategyPic::class.java)
                startActivity(intent)
            }
        }


        //  getNewDeal()
        newDeal_Btn.setOnClickListener {

         /*   if ((playerLeftBlackJack || playerRightBlackJack) && (dealerCards[0] == 10 || dealerCards[0] == 11))
            {
                block = false
            }*/

            if (!blockEveryBtn) {
                testar()
            }

        }




            //  playerCards

            stand_Btn.setOnClickListener {
                cards_Btn.visibility = View.INVISIBLE
                stand_Btn.visibility = View.INVISIBLE
                double_Btn.visibility = View.INVISIBLE
                splitButton.visibility = View.INVISIBLE
                // if we are in split, then the check must be when the other stand is pressed or the right cards gets to high

                var showDealerCards = false
              //  playerRightBlackJack
                if (playerRightBlackJack){
                    showDealerCards = true
                }
                if (!weAreInSplit){
                    showDealerCards = true
                }


          //      if (!weAreInSplit) {
                if (showDealerCards) {
                    if (!blockclick) {
                        if (!playerLeftHasFiveCards) {
                            check("STANDLEFT")
                        }
                        //   countdown2()
                        countdownOne()
                        flipCardNumber = 1
                        flipDealerCardNumber += 1
                    }
                }
                else
                {
                    showCardStandBtnRight()
                    playerLeftPressedStand = true
                    flipCardNumber = 1 // prepare for right side
                }
            }


            cards_Btn.setOnClickListener{
                if (!blockclick)
                {
                    double_Btn.visibility = View.INVISIBLE
                    splitButton.visibility = View.INVISIBLE
                    check("CARDSLEFT")

                    flipDealerCardNumber = 1

                    randomCardsIntValue = cardArray.getOneRandomCardsValue()

                    if (randomCardsIntValue == null)
                    {
                        val snack = Snackbar.make(it, "Shuffle", Snackbar.LENGTH_INDEFINITE)
                        snack.setAction("Jepp")
                        {

                        }
                        snack.show()
                    }

           /*         var slask1 = findViewById<TextView>(R.id.addUpDealer1)

                    Log.i(
                        "här kommer imagenumber ",
                        "hej hopp " + randomCardsIntValue[0].name.toString()
                    )
                    Log.i(
                        "här kommer imagenumber ",
                        "hej hopp " + randomCardsIntValue[0].value.toString()
                    )

                    slask1.text = randomCardsIntValue[0].value.toString()*/

                  //  var imageName = "R.drawable.clubs"

                    setColorOfAnImageView(flip_card1, 0)

                    if (flipCardNumber == 1) {
                        playerCards.add(randomCardsIntValue[0].value)
                        sumplayer = playerCards[0] + playerCards[1] + playerCards[2]

                        // men vi måste hantera flera ess
                        var countAce = 0
                        for (i in 0..playerCards.size-1)
                        {
                            if (playerCards[i] == 11){
                                countAce++
                            }
                        }
                        if (countAce > 1){
                            sumplayer = sumplayer - (countAce-1)*10

                            if(sumplayer > 21){
                                sumplayer = playerCards[0] + playerCards[1] + playerCards[2]
                                sumplayer = sumplayer - countAce*10
                            }
                        }
                        if (countAce == 1){
                            if(sumplayer > 21){
                                sumplayer = playerCards[0] + playerCards[1] + playerCards[2]
                                sumplayer = sumplayer - countAce*10
                            }
                        }

                       /* if (playerCards[0] == 11 || playerCards[1] == 11 || playerCards[2] == 11) {
                            sumplayer = playerCards[0] + playerCards[1] + playerCards[2] - 10
                        }*/

                        addPlayerCards.text = (sumplayer).toString()
                        if (sumplayer > 21) {
                            addPlayerCards.setBackgroundColor(Color.RED)
                         //   addPlayerCards.text = "Dealer Wins " + (sumplayer).toString()

                            flipCardNumber = 0 // prepare for right side
                            playerLeftToMuch = true
                            showCoinsX()
       /*                     if (playerRightBlackJack) {
                                cards2Btn.visibility = View.INVISIBLE
                            }*/
                            stack = stack - 100
      //                      stackOfCoins.text = stack.toString()
                        }
                        flip_card1.setImageDrawable(getDrawable(randomCardsIntValue[0].name))
                    }

                    if (flipCardNumber == 2) {
                        playerCards.add(randomCardsIntValue[0].value)
                        sumplayer =
                            playerCards[0] + playerCards[1] + playerCards[2] + playerCards[3]

                       /* if (playerCards[0] == 11 || playerCards[1] == 11 || playerCards[2] == 11 || playerCards[3] == 11) {
                            sumplayer =
                                playerCards[0] + playerCards[1] + playerCards[2] + playerCards[3] - 10
                        }*/
                        // men vi måste hantera flera ess
                        var countAce = 0
                        for (i in 0..playerCards.size-1)
                        {
                            if (playerCards[i] == 11){
                                countAce++
                            }
                        }
                        if (countAce > 1){
                            sumplayer = sumplayer - (countAce-1)*10
                            if(sumplayer > 21){
                                sumplayer = playerCards[0] + playerCards[1] + playerCards[2] + playerCards[3]
                                sumplayer = sumplayer - countAce*10
                            }
                        }
                        if (countAce == 1){
                            if(sumplayer > 21){
                                sumplayer = playerCards[0] + playerCards[1] + playerCards[2] + playerCards[3]
                                sumplayer = sumplayer - countAce*10
                            }
                        }
                        addPlayerCards.text = (sumplayer).toString()
                        if (sumplayer > 21) {
                            addPlayerCards.setBackgroundColor(Color.RED)
                  //          addPlayerCards.text = "Dealer Wins " + (sumplayer).toString()

                            flipCardNumber = 0 // prepare for right side
                            playerLeftToMuch = true
                            showCoinsX()
                            stack = stack - 100
          //                  stackOfCoins.text = stack.toString()
                        }

                        //    addPlayerCards.text = (playerCards[0] + playerCards[1] + playerCards[2] + playerCards[3]).toString()
                        flip_card2.setImageDrawable(getDrawable(randomCardsIntValue[0].name))
                    }

                    if (flipCardNumber == 3) {
                        playerCards.add(randomCardsIntValue[0].value)
                        sumplayer =
                            playerCards[0] + playerCards[1] + playerCards[2] + playerCards[3] + playerCards[4]

                       /* if (playerCards[0] == 11 || playerCards[1] == 11 || playerCards[2] == 11 || playerCards[3] == 11 || playerCards[4] == 11) {
                            sumplayer =
                                playerCards[0] + playerCards[1] + playerCards[2] + playerCards[3] + playerCards[4] - 10
                        }*/
                        // men vi måste hantera flera ess
                        var countAce = 0
                        for (i in 0..playerCards.size-1)
                        {
                            if (playerCards[i] == 11){
                                countAce++
                            }
                        }
                        if (countAce > 1){
                            sumplayer = sumplayer - (countAce-1)*10
                            if(sumplayer > 21){
                                sumplayer = playerCards[0] + playerCards[1] + playerCards[2] + playerCards[3] + playerCards[4]
                                sumplayer = sumplayer - countAce*10
                            }
                        }
                        if (countAce == 1){

                            if(sumplayer > 21){
                                sumplayer = playerCards[0] + playerCards[1] + playerCards[2] + playerCards[3] + playerCards[4]
                                sumplayer = sumplayer - countAce*10
                            }
                        }
                        addPlayerCards.text = (sumplayer).toString()
                        if (sumplayer > 21) {
                            addPlayerCards.setBackgroundColor(Color.RED)
                     //       addPlayerCards.text = "Dealer Wins " + (sumplayer).toString()

                            flipCardNumber = 0 // prepare for right side
                            playerLeftToMuch = true
                            showCoinsX()
                            stack = stack - 100
      //                      stackOfCoins.text = stack.toString()
                        }
                        else{
                            playerLeftHasFiveCards = true
                            sumplayer = 21
                            addPlayerCards.text = (sumplayer).toString()
                        }


                        cards_Btn.visibility = View.INVISIBLE
         //               stand_Btn.visibility = View.INVISIBLE
                        flip_card3.setImageDrawable(getDrawable(randomCardsIntValue[0].name))
                    }
                    flipCardNumber += 1
                }
            }


            double_Btn.setOnClickListener {
                if (!blockclick) {
                    double_Btn.visibility = View.INVISIBLE
                    splitButton.visibility = View.INVISIBLE
                    CardStandBtnLeftInvisible()

                    showCoinsDouble()
                    check("DOUBLE")

                    flipDealerCardNumber = 1

                    randomCardsIntValue = cardArray.getOneRandomCardsValue()

                    if (randomCardsIntValue == null)
                    {
                        val snack = Snackbar.make(it, "Shuffle", Snackbar.LENGTH_INDEFINITE)
                        snack.setAction("Jepp")
                        {

                        }
                        snack.show()
                    }

       /*             var slask1 = findViewById<TextView>(R.id.addUpDealer1)

                    Log.i(
                        "här kommer imagenumber ",
                        "hej hopp " + randomCardsIntValue[0].name.toString()
                    )
                    Log.i(
                        "här kommer imagenumber ",
                        "hej hopp " + randomCardsIntValue[0].value.toString()
                    )

                    slask1.text = randomCardsIntValue[0].value.toString()*/

                    var imageName = "R.drawable.clubs"

                    setColorOfAnImageView(flip_card1, 0)

                    if (flipCardNumber == 1) {
                        playerCards.add(randomCardsIntValue[0].value)

                        sumplayer = playerCards[0] + playerCards[1] + playerCards[2]

                        // men vi måste hantera flera ess
                      /*  if (playerCards[0] == 11 || playerCards[1] == 11 || playerCards[2] == 11) {
                            sumplayer = playerCards[0] + playerCards[1] + playerCards[2] - 10
                        }*/

                        var countAce = 0
                        for (i in 0..playerCards.size-1)
                        {
                            if (playerCards[i] == 11){
                                countAce++
                            }
                        }
                        if (countAce > 1){
                            sumplayer = sumplayer - (countAce-1)*10

                            if(sumplayer > 21){
                                sumplayer = playerCards[0] + playerCards[1] + playerCards[2]
                                sumplayer = sumplayer - countAce*10
                            }
                        }
                        if (countAce == 1){
                            if(sumplayer > 21){
                                sumplayer = playerCards[0] + playerCards[1] + playerCards[2]
                                sumplayer = sumplayer - countAce*10
                            }
                        }

                        addPlayerCards.text = (sumplayer).toString()
                        if (sumplayer > 21) {
                            addPlayerCards.setBackgroundColor(Color.RED)
            //                addPlayerCards.text = "Dealer Wins " + (sumplayer).toString()
                            showCoinsX()
                            stack = stack - 100
      //                      stackOfCoins.text = stack.toString()
                        }
                        else{
                            countdownOne()
                        }
                        flip_card1.setImageDrawable(getDrawable(randomCardsIntValue[0].name))
                    }



                    flipCardNumber = 1

                    flipDealerCardNumber += 1

                    //-------
                }
            }


        back_side_card.setOnClickListener {

            back_side_card.setImageDrawable(getDrawable(R.drawable.t_c1))

            back_side_card.setImageDrawable(getDrawable(R.drawable.clubs_2))

        }


            splitButton.setOnClickListener {

                // block split if it is not same value
                if (playerCards[0] == playerCards[1]) {
                    if (!blockclick) {
                        splitAces = true
                        addPlayerCards2.visibility = View.VISIBLE

                        check("SPLIT")
                        returnStringGlobal = ""

                        showCoinsSplit()
                        right_down_card1.setImageDrawable(getDrawable(playerCardsName[1]))

                        playerCards_split.add(playerCards[1])
                        var playerCardTemp = playerCards[0]
                        playerCards.clear()
                     //   playerCards.removeAll()
                        playerCards.add(playerCardTemp)
                      //  playerCards.add(playerCards_test[0])
                     //  playerCards.add(11)
                        var randomCardsIntValueH = cardArray.getOneRandomCardsValue()

                        if (randomCardsIntValueH == null)
                        {
                            val snack = Snackbar.make(it, "Shuffle", Snackbar.LENGTH_INDEFINITE)
                            snack.setAction("Jepp")
                            {

                            }
                            snack.show()
                        }

                        left_down_card2.setImageDrawable(getDrawable(randomCardsIntValueH[0].name))
                        playerCards.add(randomCardsIntValueH[0].value)
                   //     playerCards[1] = randomCardsIntValueH[0].value

                        randomCardsIntValueH = cardArray.getOneRandomCardsValue()

                        if (randomCardsIntValueH == null)
                        {
                            val snack = Snackbar.make(it, "Shuffle", Snackbar.LENGTH_INDEFINITE)
                            snack.setAction("Jepp")
                            {

                            }
                            snack.show()
                        }

                        right_down_card2.setImageDrawable(getDrawable(randomCardsIntValueH[0].name))
                        playerCards_split.add(randomCardsIntValueH[0].value)

                        // we have to check for black jack here

                        sumplayer = playerCards[0] + playerCards[1]

                        // os måste kolla om 2 äss
                        if (sumplayer == 22){
                            sumplayer -= 10
                        }
                        addPlayerCards.text = sumplayer.toString()

                        // if we got 21 on two cards, then we get 1.5 on the money and its a new deal
                        // block all click on the buttons

                        if (sumplayer == 21) {
                            Toast.makeText(this, "21 ger 1,5 gånger pengarna", Toast.LENGTH_LONG).show()
                            playerLeftBlackJack = true
                            cards_Btn.visibility = View.INVISIBLE
                            stand_Btn.visibility = View.INVISIBLE


                            coins += 5
                            showCoins()
                            showCardStandBtnRight()
                            showCoinsSplit_right()

                           // testar blockclick = true
                        }
                        else
                        {
                            blockclick = false
                        }

                        sumplayer_split = playerCards_split[0] + playerCards_split[1]

                        if (sumplayer_split == 22){
                            sumplayer_split -= 10
                        }
                        // if we got 21 on two cards, then we get 1.5 on the money and its a new deal
                        // block all click on the buttons

                        addPlayerCards2.text = sumplayer_split.toString()

                        if (sumplayer_split == 21) {
                            Toast.makeText(this, "21 ger 1,5 gånger pengarna", Toast.LENGTH_LONG).show()
                            playerRightBlackJack = true

                            Log.i("size", "card1  " + playerCards[0])
                            Log.i("size", "card2  " + playerCards[1])

                  //          addPlayerCards.text = playerCards[0].toString()
                      //      addPlayerCards2.text = playerCards[1].toString()

                            cards2_Btn.visibility = View.INVISIBLE
                            stand2_Btn.visibility = View.INVISIBLE

                            coins += 5
                            showCoins()

                            // bör inte släcka coins i showcoins
                            if (!playerLeftBlackJack) {
                                showPlayerCoins()
                            }
                            // kan vi plocka bort blockclick kanske ?
                         //   blockclick = true
                        }
                        else
                        {
                            blockclick = false
                        }
                        // the dealer must be given a chance to get a black jack
                        if (playerLeftBlackJack && playerRightBlackJack){
                            if (dealerCards[0] == 10 || dealerCards[0] == 11)
                            {
                                blockEveryBtn = true
                                stand2_Btn.visibility = View.VISIBLE
                            }
                        }

                        if (splitAces)
                        {

                            cards_Btn.visibility = View.INVISIBLE
                            stand_Btn.visibility = View.INVISIBLE
                            cards2_Btn.visibility = View.INVISIBLE
                            stand2_Btn.visibility = View.INVISIBLE
                            countdownOne()

                        }

                        //               right_down_card2.visibility = View.VISIBLE
                    }
                }
            }

        // we are in split. If we get more than 21 and the left cards are in the game, then start dealer cards
        cards2_Btn.setOnClickListener{

   /*         { if (!weAreInSplit)
                playerLeftPressedStand = true
            }*/
            // we know that it is split since the button is pressed
            // dont think we need blockclick
            var blockclickHere = false
            if ((!playerLeftPressedStand) || (blockclick)){
                blockclickHere = true
            }
            if (playerLeftToMuch){
                blockclickHere = false
            }

            if (playerLeftBlackJack){
                blockclickHere = false
            }

            if (!blockclickHere)
            {
                check("CARDSRIGHT")

                flipDealerCardNumber = 1

                randomCardsIntValue = cardArray.getOneRandomCardsValue()

                if (randomCardsIntValue == null)
                {
                    val snack = Snackbar.make(it, "Shuffle", Snackbar.LENGTH_INDEFINITE)
                    snack.setAction("Jepp")
                    {

                    }
                    snack.show()
                }

    /*            var slask1 = findViewById<TextView>(R.id.addUpDealer1)

                Log.i(
                    "här kommer imagenumber ",
                    "hej hopp " + randomCardsIntValue[0].name.toString()
                )
                Log.i(
                    "här kommer imagenumber ",
                    "hej hopp " + randomCardsIntValue[0].value.toString()
                )

                slask1.text = randomCardsIntValue[0].value.toString()*/

                var imageName = "R.drawable.clubs"

                setColorOfAnImageView(flip_card1, 0)



                if (flipCardNumber == 1) {
                    playerCards_split.add(randomCardsIntValue[0].value)
                    sumplayer_split = playerCards_split[0] + playerCards_split[1] + playerCards_split[2]

                    // men vi måste hantera flera ess
           /*         if (playerCards_split[0] == 11 || playerCards_split[1] == 11 || playerCards_split[2] == 11) {
                        sumplayer_split = playerCards_split[0] + playerCards_split[1] + playerCards_split[2] - 10
                    }*/

                    var countAce = 0
                    for (i in 0..playerCards_split.size-1)
                    {
                        if (playerCards_split[i] == 11){
                            countAce++
                        }
                    }

                    // rätt ?
                /*    if (countAce > 0){
                        sumplayer_split = sumplayer_split - countAce*10
                    }*/
                    if (countAce > 1){
                        sumplayer_split = sumplayer_split - (countAce-1)*10
                        if(sumplayer_split > 21){
                            sumplayer_split = playerCards_split[0] + playerCards_split[1] + playerCards_split[2]
                            sumplayer_split = sumplayer_split - countAce*10
                        }
                    }
                    if (countAce == 1){

                        if(sumplayer_split > 21){
                            sumplayer_split = playerCards_split[0] + playerCards_split[1] + playerCards_split[2]
                            sumplayer_split = sumplayer_split - countAce*10
                        }
                    }


                    addPlayerCards2.text = (sumplayer_split).toString()
                    if (sumplayer_split > 21) {
                        addPlayerCards2.setBackgroundColor(Color.RED)
     //                   addPlayerCards2.text = "Dealer Wins " + (sumplayer_split).toString()
                        showCoinsX_right()
                        playerRightToMuch = true
                        // testar
                    //    if(playerLeftBlackJack || playerLeftToMuch || playerLeftPressedStand) {
        /*                if(playerLeftPressedStand)
                        {
                            countdownOne()
                        }*/

                        stack = stack - 100
     //                   stackOfCoins.text = stack.toString()
                    }
                    flip_card1_split.setImageDrawable(getDrawable(randomCardsIntValue[0].name))
                }

                if (flipCardNumber == 2) {
                    playerCards_split.add(randomCardsIntValue[0].value)
                    sumplayer_split =
                        playerCards_split[0] + playerCards_split[1] + playerCards_split[2] + playerCards_split[3]

                    /*       if (playerCards_split[0] == 11 || playerCards_split[1] == 11 || playerCards_split[2] == 11 || playerCards_split[3] == 11) {
                        sumplayer_split =
                            playerCards_split[0] + playerCards_split[1] + playerCards_split[2] + playerCards_split[3] - 10}*/

                    var countAce = 0
                    for (i in 0..playerCards_split.size - 1) {
                        if (playerCards_split[i] == 11) {
                            countAce++
                        }
                    }
                    if (countAce > 1){
                        sumplayer_split = sumplayer_split - (countAce-1)*10
                        if(sumplayer_split > 21){
                            sumplayer_split =
                                playerCards_split[0] + playerCards_split[1] + playerCards_split[2] + playerCards_split[3]
                            sumplayer_split = sumplayer_split - countAce*10
                        }
                    }
                    if (countAce == 1){

                        if(sumplayer_split > 21){
                            sumplayer_split =
                                playerCards_split[0] + playerCards_split[1] + playerCards_split[2] + playerCards_split[3]
                            sumplayer_split = sumplayer_split - countAce*10
                        }
                    }


                    addPlayerCards2.text = (sumplayer_split).toString()
                    if (sumplayer_split > 21) {
                        addPlayerCards2.setBackgroundColor(Color.RED)
      //                  addPlayerCards2.text = "Dealer Wins " + (sumplayer_split).toString()
                        showCoinsX_right()
                        playerRightToMuch = true
                        // testar
                    //    if(playerLeftBlackJack || playerLeftToMuch || playerLeftPressedStand) {
              /*          if(playerLeftPressedStand)
                        {
                            countdownOne()
                        }*/

                        stack = stack - 100
     //                   stackOfCoins.text = stack.toString()
                    }

                    //    addPlayerCards.text = (playerCards[0] + playerCards[1] + playerCards[2] + playerCards[3]).toString()
                    flip_card2_split.setImageDrawable(getDrawable(randomCardsIntValue[0].name))
                }

                if (flipCardNumber == 3) {
                    playerCards_split.add(randomCardsIntValue[0].value)
                    sumplayer_split =
                        playerCards_split[0] + playerCards_split[1] + playerCards_split[2] + playerCards_split[3] + playerCards_split[4]

                    /*if (playerCards_split[0] == 11 || playerCards_split[1] == 11 || playerCards_split[2] == 11 || playerCards_split[3] == 11 || playerCards_split[4] == 11) {
                        sumplayer_split =
                            playerCards_split[0] + playerCards_split[1] + playerCards_split[2] + playerCards_split[3] + playerCards_split[4] - 10
                    }*/

                    var countAce = 0
                    for (i in 0..playerCards_split.size - 1) {
                        if (playerCards_split[i] == 11) {
                            countAce++
                        }
                    }
                    if (countAce > 1){
                        sumplayer_split = sumplayer_split - (countAce-1)*10
                        if(sumplayer_split > 21){
                            sumplayer_split =
                                playerCards_split[0] + playerCards_split[1] + playerCards_split[2] + playerCards_split[3] + playerCards_split[4]
                            sumplayer_split = sumplayer_split - countAce*10
                        }
                    }
                    if (countAce == 1){

                        if(sumplayer_split > 21){
                            sumplayer_split =
                                playerCards_split[0] + playerCards_split[1] + playerCards_split[2] + playerCards_split[3] + playerCards_split[4]
                            sumplayer_split = sumplayer_split - countAce*10
                        }
                    }

                    addPlayerCards2.text = (sumplayer_split).toString()
                    if (sumplayer_split > 21) {
                        addPlayerCards2.setBackgroundColor(Color.RED)
         //               addPlayerCards2.text = "Dealer Wins " + (sumplayer_split).toString()
                        showCoinsX_right()
                        playerRightToMuch = true

                        stack = stack - 100
      //                  stackOfCoins.text = stack.toString()
                    }
                    else{
                        playerRightHasFiveCards = true
                        sumplayer_split = 21
                        addPlayerCards2.text = (sumplayer_split).toString()
                    }

                    cards2_Btn.visibility = View.INVISIBLE
     //               stand2_Btn.visibility = View.INVISIBLE
                    flip_card3_split.setImageDrawable(getDrawable(randomCardsIntValue[0].name))
                }


                if((playerLeftPressedStand || playerLeftBlackJack) && playerRightToMuch)
                {
                    Log.i("size", "stand and to much")
                    countdownOne()
                }

                flipCardNumber += 1

            }
        }

        stand2_Btn.setOnClickListener {
            cards2_Btn.visibility = View.INVISIBLE
            stand2_Btn.visibility = View.INVISIBLE

            var blockclickHere = false
            if ((!playerLeftPressedStand) || (blockclick)){
                blockclickHere = true
            }
            if (playerLeftToMuch){
                blockclickHere = false
            }
            if (playerLeftBlackJack){
                blockclickHere = false
            }

            if (!blockclickHere) {
                if (!playerRightHasFiveCards) {
                    check("STANDRIGHT")
                }

                countdownOne()

                flipCardNumber = 1

                flipDealerCardNumber += 1
            }
        }
    }




    fun playSound(start : Boolean) {

        var resId = getResources().getIdentifier(
            R.raw.tal.toString(),
            "raw", this?.packageName
        )


        if (start) {
            if(mediaPlayer == null)
            {
                mediaPlayer = MediaPlayer.create(this, resId)
                mediaPlayer!!.start()
            } else {
                mediaPlayer!!.seekTo(0)
                mediaPlayer!!.start()
            }
        } else {
            //  mediaPlayer.stop()
            //           while (mediaPlayer.isPlaying())
            //          {
            if(mediaPlayer != null)
            {
                mediaPlayer!!.pause()
            }

            //    mediaPlayer.stop()
            //          }
        }
    }

    fun checkAccordingToStrategy(playerCard1 : Int, playerCard2: Int, dealerCard : Int, sum : Int) {
        cardArray.checkStrategy(playerCard1,playerCard2,dealerCard, sum)

     //   checkStrategy(playerCard1 : Int, playerCard2: Int, dealerCard : Int)
    }

    fun testar() {

        var left_down_card = findViewById<ImageView>(R.id.leftDownCard1)
        var left_down_card2 = findViewById<ImageView>(R.id.leftDownCard2)
        var right_down_card1 = findViewById<ImageView>(R.id.rightDownCard1)
        var right_down_card2 = findViewById<ImageView>(R.id.rightDownCard2)

        var splitButton = findViewById<Button>(R.id.splitBtn)
        var double_Btn = findViewById<Button>(R.id.doubleBtn)

        var flip_lefttopcard = findViewById<ImageView>(R.id.leftTopCard)
        var addPlayerCardsHigh = findViewById<TextView>(R.id.addUpPlayerHigh)
        var addPlayerCardsLow = findViewById<TextView>(R.id.addUpPlayerLow)

        var flip_card1 = findViewById<ImageView>(R.id.flipCard1)
        var flip_card2 = findViewById<ImageView>(R.id.flipCard2)
        var flip_card3 = findViewById<ImageView>(R.id.flipCard3)
      //  var flip_card4 = findViewById<ImageView>(R.id.flipCard4)

        var flip_card1_split = findViewById<ImageView>(R.id.flipCard1_split)
        var flip_card2_split = findViewById<ImageView>(R.id.flipCard2_split)
        var flip_card3_split = findViewById<ImageView>(R.id.flipCard3_split)
    //    var flip_card4_split = findViewById<ImageView>(R.id.flipCard4_split)


        var addupdealer1 = findViewById<TextView>(R.id.addUpDealer1)
        var addPlayer2CardsHigh = findViewById<TextView>(R.id.addUpPlayer2High)
        var addPlayer2CardsLow = findViewById<TextView>(R.id.addUpPlayer2Low)
        var randomCardsIntValueH = cardArray.getOneRandomCardsValue()

        var flip_dealercard2 = findViewById<ImageView>(R.id.dealercard2)
        var flip_dealercard3 = findViewById<ImageView>(R.id.dealercard3)
        var flip_dealercard4 = findViewById<ImageView>(R.id.dealercard4)
        var flip_dealercard5 = findViewById<ImageView>(R.id.dealercard5)

        var coins1_player_x = findViewById<ImageView>(R.id.coins1_player_x)
        var coins2_player_x = findViewById<ImageView>(R.id.coins2_player_x)
        var coins3_player_x = findViewById<ImageView>(R.id.coins3_player_x)
        var coins4_player_x = findViewById<ImageView>(R.id.coins4_player_x)

        var coins1_player = findViewById<ImageView>(R.id.coins1_player)
        var coins2_player = findViewById<ImageView>(R.id.coins2_player)
        var coins3_player = findViewById<ImageView>(R.id.coins3_player)
        var coins4_player = findViewById<ImageView>(R.id.coins4_player)

        var coins1_player2_x = findViewById<ImageView>(R.id.coins1_player2_x)
        var coins2_player2_x = findViewById<ImageView>(R.id.coins2_player2_x)
        var coins3_player2_x = findViewById<ImageView>(R.id.coins3_player2_x)
        var coins4_player2_x = findViewById<ImageView>(R.id.coins4_player2_x)

        var coins1_player2 = findViewById<ImageView>(R.id.coins1_player2)
        var coins2_player2 = findViewById<ImageView>(R.id.coins2_player2)
        var coins3_player2 = findViewById<ImageView>(R.id.coins3_player2)
        var coins4_player2 = findViewById<ImageView>(R.id.coins4_player2)

        var cards2Btn = findViewById<Button>(R.id.cards2Btn)
        var stand2Btn = findViewById<Button>(R.id.stand2Btn)

        var cardsBtn = findViewById<Button>(R.id.cardsBtn)
        var standBtn = findViewById<Button>(R.id.standBtn)

        var linearLayoutRight = findViewById<LinearLayout>(R.id.linearLayoutRight)
        var playerFlipCards2LL = findViewById<LinearLayout>(R.id.playerFlipCards2LL)

        if (randomCardsIntValueH == null)
        {
            Toast.makeText(this, "Shuffle", Toast.LENGTH_LONG).show()
            // jag kunde inte använda this och inte it
      /*      val snack = Snackbar.make(it, "Shuffle", Snackbar.LENGTH_INDEFINITE)
            snack.setAction("Jepp")
            {

            }
            snack.show()*/
        }

        playerLeftHasFiveCards = false
        playerRightHasFiveCards = false
        splitAces = false

        linearLayoutRight.visibility = View.INVISIBLE
        playerFlipCards2LL.visibility = View.INVISIBLE

        coins1_player.visibility = View.INVISIBLE
        coins2_player.visibility = View.INVISIBLE
        coins3_player.visibility = View.INVISIBLE
        coins4_player.visibility = View.INVISIBLE

        coins1_player_x.visibility = View.INVISIBLE
        coins2_player_x.visibility = View.INVISIBLE
        coins3_player_x.visibility = View.INVISIBLE
        coins4_player_x.visibility = View.INVISIBLE

        coins1_player2.visibility = View.INVISIBLE
        coins2_player2.visibility = View.INVISIBLE
        coins3_player2.visibility = View.INVISIBLE
        coins4_player2.visibility = View.INVISIBLE

        coins1_player2_x.visibility = View.INVISIBLE
        coins2_player2_x.visibility = View.INVISIBLE
        coins3_player2_x.visibility = View.INVISIBLE
        coins4_player2_x.visibility = View.INVISIBLE

        right_down_card1.visibility = View.INVISIBLE
        right_down_card2.visibility = View.INVISIBLE

        splitButton.visibility = View.INVISIBLE
        double_Btn.visibility = View.VISIBLE

        cards2Btn.visibility = View.INVISIBLE
        stand2Btn.visibility = View.INVISIBLE

        cardsBtn.visibility = View.VISIBLE
        standBtn.visibility = View.VISIBLE

   //     var noMoneyLeft1 = findViewById<TextView>(R.id.noMoneyLeftTV1)
  //      var noMoneyLeft2 = findViewById<TextView>(R.id.noMoneyLeftTV2)
        var survivedDeals = findViewById<TextView>(R.id.survivedDealsTV)

        // All the money spent, new round
        if (coins < 2) { // TODO hej

            if (survivedDeals.text != "") {
                coins = 14
                survivedCountDeals = 0
                survivedDeals.text = ""
    //            noMoneyLeft1.visibility = View.INVISIBLE
     //           noMoneyLeft2.visibility = View.INVISIBLE

            } else {

                survivedDeals.text = survivedCountDeals.toString()
   //             noMoneyLeft1.visibility = View.VISIBLE
    //            noMoneyLeft2.visibility = View.VISIBLE

                survivedCountDeals = 0
                return
            }
        }

        survivedDeals.text = survivedCountDeals.toString()

        addPlayerCardsHigh.setBackgroundColor(Color.WHITE)
        addPlayerCardsHigh.visibility = View.VISIBLE
        addPlayerCardsLow.visibility = View.INVISIBLE
        addPlayer2CardsHigh.setBackgroundColor(Color.WHITE)
        addPlayer2CardsHigh.visibility = View.INVISIBLE
        addPlayer2CardsLow.visibility = View.INVISIBLE

        addupdealer1.setBackgroundColor(Color.WHITE)

        coins -= 2
        survivedCountDeals += 1

        // testar
        playerLeftRightCoinsInvisible()

        showCoins()
        showPlayerCoins()



        LeftSideDone = false
        RightSideDone = false

        playerLeftBlackJack = false
        playerRightBlackJack = false

        playerLeftToMuch = false
        playerRightToMuch = false

        weAreInSplit = false
        blockclick = false

        noAceNoPair = false
        DoubleActive = false

        dealerNoMoreCards = 0

     //   TODO kolla skillnad removeall och clear
        playerCardsName.clear()
        playerCards.clear()

      //  playerCards.removeAll

        dealerCards.clear()
        playerCards_split.clear()

        Log.i("här kommer imagenumber ", "hej hopp " + randomCardsIntValueH[0].name.toString())
        Log.i("här kommer imagenumber ", "hej hopp " + randomCardsIntValueH[0].value.toString())

        //  slask1H.text = randomCardsIntValueH[0].value.toString()
        left_down_card.setImageDrawable(getDrawable(randomCardsIntValueH[0].name))
        playerCards.add(randomCardsIntValueH[0].value)
        playerCardsName.add(randomCardsIntValueH[0].name)

        randomCardsIntValueH = cardArray.getOneRandomCardsValue()

        if (randomCardsIntValueH == null)
        {
            Toast.makeText(this, "Shuffle", Toast.LENGTH_LONG).show()
        /*    val snack = Snackbar.make(this, "Shuffle", Snackbar.LENGTH_INDEFINITE)
            snack.setAction("Jepp")
            {

            }
            snack.show()*/
        }
        left_down_card2.setImageDrawable(getDrawable(randomCardsIntValueH[0].name))
        playerCards.add(randomCardsIntValueH[0].value)
        playerCardsName.add(randomCardsIntValueH[0].name) // only save for split

        addPlayerCardsHigh.text = (playerCards[0] + playerCards[1]).toString()

        if (playerCards[0] == playerCards[1]){
            splitButton.visibility = View.VISIBLE
        }

        randomCardsIntValueH = cardArray.getOneRandomCardsValue()

        if (randomCardsIntValueH == null)
        {
            Toast.makeText(this, "Shuffle", Toast.LENGTH_LONG).show()
       /*     val snack = Snackbar.make(it, "Shuffle", Snackbar.LENGTH_INDEFINITE)
            snack.setAction("Jepp")
            {

            }
            snack.show()*/
        }

        flip_lefttopcard.setImageDrawable(getDrawable(randomCardsIntValueH[0].name))
        dealerCards.add(randomCardsIntValueH[0].value)

        addupdealer1.text = randomCardsIntValueH[0].value.toString()
        //   addupdealer2.text = randomCardsIntValueH[0].value.toString()


        flip_card1.setImageDrawable(getDrawable(R.drawable.t_back_card))
        flip_card2.setImageDrawable(getDrawable(R.drawable.t_back_card))
        flip_card3.setImageDrawable(getDrawable(R.drawable.t_back_card))
   //     flip_card4.setImageDrawable(getDrawable(R.drawable.t_back_card))

        flip_dealercard2.setImageDrawable(getDrawable(R.drawable.t_back_card))
        flip_dealercard3.setImageDrawable(getDrawable(R.drawable.t_back_card))
        flip_dealercard4.setImageDrawable(getDrawable(R.drawable.t_back_card))
        flip_dealercard5.setImageDrawable(getDrawable(R.drawable.t_back_card))

        flip_card1_split.setImageDrawable(getDrawable(R.drawable.t_back_card))
        flip_card2_split.setImageDrawable(getDrawable(R.drawable.t_back_card))
        flip_card3_split.setImageDrawable(getDrawable(R.drawable.t_back_card))
    //    flip_card4_split.setImageDrawable(getDrawable(R.drawable.t_back_card))



   /*     if (playerCards[0] == 11 || playerCards[1] == 11) {
            addPlayerCards2.text = (playerCards[0] + playerCards[1] - 10).toString()
        } else {
            addPlayerCards2.text = "0"
        }*/

        // se mer här
        sumplayer = playerCards[0] + playerCards[1]

        if (sumplayer == 22){
            sumplayer -= 10
        }
        addPlayerCardsHigh.text = sumplayer.toString()

        // if we got 21 on two cards, then we get 1.5 on the money and its a new deal
        // block all click on the buttons



        if (sumplayer == 21) {
          Toast.makeText(this, "21 ger 1,5 gånger pengarna", Toast.LENGTH_LONG).show()
            cardsBtn.visibility = View.INVISIBLE
            double_Btn.visibility = View.INVISIBLE
            playerLeftBlackJack = true

            // we know the bet is 2
            coins += 5
            showCoins()

            // dealer must be given a chance to get black jack
            if (dealerCards[0] == 10 || dealerCards[0] == 11){
                standBtn.visibility = View.VISIBLE

                blockEveryBtn = true
            }
            else {
                standBtn.visibility = View.INVISIBLE
                blockclick = true
            }
        }
        else
        {
            blockclick = false
        }

        if (coins < 2) { // TODO hej
            splitDoubleBtnInvisible()
        }


        flipCardNumber = 1
        flipDealerCardNumber = 1
    }

    fun showCoinsX_invisible() {
        var coins1_player_x = findViewById<ImageView>(R.id.coins1_player_x)
        var coins2_player_x = findViewById<ImageView>(R.id.coins2_player_x)
        var coins3_player_x = findViewById<ImageView>(R.id.coins3_player_x)
        var coins4_player_x = findViewById<ImageView>(R.id.coins4_player_x)


        coins1_player_x.visibility = View.INVISIBLE
        coins2_player_x.visibility = View.INVISIBLE

       // if (DoubleActive) {
            coins3_player_x.visibility = View.INVISIBLE
            coins4_player_x.visibility = View.INVISIBLE
     //   }
    }

    fun showCoinsX(){
        var coins1_player_x = findViewById<ImageView>(R.id.coins1_player_x)
        var coins2_player_x = findViewById<ImageView>(R.id.coins2_player_x)
        var coins3_player_x = findViewById<ImageView>(R.id.coins3_player_x)
        var coins4_player_x = findViewById<ImageView>(R.id.coins4_player_x)
        var survivedDeals = findViewById<TextView>(R.id.survivedDealsTV)
   //     var noMoneyLeft1 = findViewById<TextView>(R.id.noMoneyLeftTV1)
   //     var noMoneyLeft2 = findViewById<TextView>(R.id.noMoneyLeftTV2)
        var cards_Btn = findViewById<Button>(R.id.cardsBtn)
        var stand_Btn = findViewById<Button>(R.id.standBtn)
        var cards2Btn = findViewById<Button>(R.id.cards2Btn)
        var stand2Btn = findViewById<Button>(R.id.stand2Btn)


        // not sure
        blockEveryBtn = false

        cards_Btn.visibility = View.INVISIBLE
        stand_Btn.visibility = View.INVISIBLE

        coins1_player_x.visibility = View.VISIBLE
        coins2_player_x.visibility = View.VISIBLE

        if (DoubleActive){
            coins3_player_x.visibility = View.VISIBLE
            coins4_player_x.visibility = View.VISIBLE
        }

        if (coins < 2)
        { // TODO hej

            survivedDeals.text = survivedCountDeals.toString()
     //       noMoneyLeft1.visibility = View.VISIBLE
    //        noMoneyLeft2.visibility = View.VISIBLE
            survivedCountDeals = 0

        }

        if (weAreInSplit) {
            cards2Btn.visibility = View.VISIBLE
            stand2Btn.visibility = View.VISIBLE
            showCardStandBtnRight()
            // Take away this option, we have already paid 1.5
            if (playerRightBlackJack) {
                cards2Btn.visibility = View.INVISIBLE
            }
        }


    }
    fun showCoinsX2(){
        var coins1_player_x = findViewById<ImageView>(R.id.coins1_player_x)
        var coins2_player_x = findViewById<ImageView>(R.id.coins2_player_x)
        var coins3_player_x = findViewById<ImageView>(R.id.coins3_player_x)
        var coins4_player_x = findViewById<ImageView>(R.id.coins4_player_x)
        var survivedDeals = findViewById<TextView>(R.id.survivedDealsTV)
    //    var noMoneyLeft1 = findViewById<TextView>(R.id.noMoneyLeftTV1)
     //   var noMoneyLeft2 = findViewById<TextView>(R.id.noMoneyLeftTV2)
        var cards_Btn = findViewById<Button>(R.id.cardsBtn)
        var stand_Btn = findViewById<Button>(R.id.standBtn)
        var cards2Btn = findViewById<Button>(R.id.cards2Btn)
        var stand2Btn = findViewById<Button>(R.id.stand2Btn)


        // not sure
        blockEveryBtn = false

        cards2Btn.visibility = View.VISIBLE
        stand2Btn.visibility = View.VISIBLE


        cards_Btn.visibility = View.INVISIBLE
        stand_Btn.visibility = View.INVISIBLE

        coins1_player_x.visibility = View.VISIBLE
        coins2_player_x.visibility = View.VISIBLE

        if (DoubleActive){
            coins3_player_x.visibility = View.VISIBLE
            coins4_player_x.visibility = View.VISIBLE
        }

        if (coins == 0)
        { // TODO hej

            survivedDeals.text = survivedCountDeals.toString()
     //       noMoneyLeft1.visibility = View.VISIBLE
     //       noMoneyLeft2.visibility = View.VISIBLE

        }

        cards2Btn.visibility = View.INVISIBLE
        stand2Btn.visibility = View.INVISIBLE
   /*     if (weAreInSplit) {

            showCardStandBtnRight()
            // Take away this option, we have already paid 1.5
            if (playerRightBlackJack) {
                cards2Btn.visibility = View.INVISIBLE
            }
        }*/


    }



    fun showCoinsX_right_invisible(){
        var coins1_player2_x = findViewById<ImageView>(R.id.coins1_player2_x)
        var coins2_player2_x = findViewById<ImageView>(R.id.coins2_player2_x)
        var coins3_player2_x = findViewById<ImageView>(R.id.coins3_player2_x)
        var coins4_player2_x = findViewById<ImageView>(R.id.coins4_player2_x)


        coins1_player2_x.visibility = View.INVISIBLE
        coins2_player2_x.visibility = View.INVISIBLE

     //   if (DoubleActive){
            coins3_player2_x.visibility = View.INVISIBLE
            coins4_player2_x.visibility = View.INVISIBLE
     //   }


    }

    fun showCoinsX_right(){
        var coins1_player2_x = findViewById<ImageView>(R.id.coins1_player2_x)
        var coins2_player2_x = findViewById<ImageView>(R.id.coins2_player2_x)
        var coins3_player2_x = findViewById<ImageView>(R.id.coins3_player2_x)
        var coins4_player2_x = findViewById<ImageView>(R.id.coins4_player2_x)
    //    var survivedDeals = findViewById<TextView>(R.id.survivedDealsTV)
     //   var noMoneyLeft1 = findViewById<TextView>(R.id.noMoneyLeftTV1)
        var noMoneyLeft2 = findViewById<TextView>(R.id.noMoneyLeftTV2)
        var cards2_Btn = findViewById<Button>(R.id.cards2Btn)
        var stand2_Btn = findViewById<Button>(R.id.stand2Btn)


        // not sure
        blockEveryBtn = false

        cards2_Btn.visibility = View.INVISIBLE
        stand2_Btn.visibility = View.INVISIBLE

        coins1_player2_x.visibility = View.VISIBLE
        coins2_player2_x.visibility = View.VISIBLE

        if (DoubleActive){
            coins3_player2_x.visibility = View.VISIBLE
            coins4_player2_x.visibility = View.VISIBLE
        }

        if (coins == 0)
        { // TODO hej
      //      survivedDeals.text = survivedCountDeals.toString()
     //       noMoneyLeft1.visibility = View.VISIBLE
            noMoneyLeft2.visibility = View.VISIBLE
        }
    }

    fun showPlayerCoins()
    {
        var coins1_player = findViewById<ImageView>(R.id.coins1_player)
        var coins2_player = findViewById<ImageView>(R.id.coins2_player)

        coins1_player.visibility = View.VISIBLE
        coins2_player.visibility = View.VISIBLE
    }

    fun playerLeftRightCoinsInvisible(){
        var coins1_player= findViewById<ImageView>(R.id.coins1_player)
        var coins2_player= findViewById<ImageView>(R.id.coins2_player)
        var coins3_player= findViewById<ImageView>(R.id.coins3_player)
        var coins4_player= findViewById<ImageView>(R.id.coins4_player)

        var coins1_player2= findViewById<ImageView>(R.id.coins1_player2)
        var coins2_player2= findViewById<ImageView>(R.id.coins2_player2)
        var coins3_player2= findViewById<ImageView>(R.id.coins3_player2)
        var coins4_player2= findViewById<ImageView>(R.id.coins4_player2)

        coins1_player.visibility = View.INVISIBLE
        coins2_player.visibility = View.INVISIBLE
        coins3_player.visibility = View.INVISIBLE
        coins4_player.visibility = View.INVISIBLE

        coins1_player2.visibility = View.INVISIBLE
        coins2_player2.visibility = View.INVISIBLE
        coins3_player2.visibility = View.INVISIBLE
        coins4_player2.visibility = View.INVISIBLE
    }

    fun showCoins(){
        var showCoins= findViewById<TextView>(R.id.showCoins)
        var coins1= findViewById<ImageView>(R.id.coins1)
        var coins2= findViewById<ImageView>(R.id.coins2)
        var coins3= findViewById<ImageView>(R.id.coins3)
        var coins4= findViewById<ImageView>(R.id.coins4)
        var coins5= findViewById<ImageView>(R.id.coins5)
        var coins6= findViewById<ImageView>(R.id.coins6)
        var coins7= findViewById<ImageView>(R.id.coins7)
        var coins8= findViewById<ImageView>(R.id.coins8)
        var coins9= findViewById<ImageView>(R.id.coins9)
        var coins10= findViewById<ImageView>(R.id.coins10)
        var coins11= findViewById<ImageView>(R.id.coins11)
        var coins12= findViewById<ImageView>(R.id.coins12)
        var coins13= findViewById<ImageView>(R.id.coins13)
        var coins14= findViewById<ImageView>(R.id.coins14)
        var coins15= findViewById<ImageView>(R.id.coins15)
        var coins16= findViewById<ImageView>(R.id.coins16)
        var coins17= findViewById<ImageView>(R.id.coins17)
        var coins18= findViewById<ImageView>(R.id.coins18)
        var coins19= findViewById<ImageView>(R.id.coins19)
        var coins20= findViewById<ImageView>(R.id.coins20)

        var bigStack1= findViewById<ImageView>(R.id.bigStack1)
        var bigStack2= findViewById<ImageView>(R.id.bigStack2)


    //    playerLeftRightCoinsInvisible()
   /*     coins1_player.visibility = View.INVISIBLE
        coins2_player.visibility = View.INVISIBLE
        coins3_player.visibility = View.INVISIBLE
        coins4_player.visibility = View.INVISIBLE

        coins1_player2.visibility = View.INVISIBLE
        coins2_player2.visibility = View.INVISIBLE
        coins3_player2.visibility = View.INVISIBLE
        coins4_player2.visibility = View.INVISIBLE*/


        var coinsLeft = coins

            coins1.visibility = View.INVISIBLE
            coins2.visibility = View.INVISIBLE
            coins3.visibility = View.INVISIBLE
            coins4.visibility = View.INVISIBLE
            coins5.visibility = View.INVISIBLE
            coins6.visibility = View.INVISIBLE
            coins7.visibility = View.INVISIBLE
            coins8.visibility = View.INVISIBLE
            coins9.visibility = View.INVISIBLE
            coins10.visibility = View.INVISIBLE
            coins11.visibility = View.INVISIBLE
            coins12.visibility = View.INVISIBLE
            coins13.visibility = View.INVISIBLE
            coins14.visibility = View.INVISIBLE
            coins15.visibility = View.INVISIBLE
            coins16.visibility = View.INVISIBLE
            coins17.visibility = View.INVISIBLE
            coins18.visibility = View.INVISIBLE
            coins19.visibility = View.INVISIBLE
            coins20.visibility = View.INVISIBLE

        showCoins.text = coins.toString()
        //       var coins9= findViewById<ImageView>(R.id.coins9)
        //       var coins10= findViewById<ImageView>(R.id.coins10)
        // I am not sure
        blockEveryBtn = false
// maybe
        showCoinsX_invisible()
        showCoinsX_right_invisible()

        if (coins > 20){
            bigStack1.visibility = View.VISIBLE
            coinsLeft -= 3
        }
        else
        {
            bigStack1.visibility = View.INVISIBLE
        }
        if (coins > 35){
            bigStack2.visibility = View.VISIBLE
            coinsLeft -= 3
        }
        else
        {
            bigStack2.visibility = View.INVISIBLE
        }

        for (i in 1..coinsLeft)
        {
            when (i) {
                1 -> {
                    coins1.visibility = View.VISIBLE
                }
                2 -> {
                    coins2.visibility = View.VISIBLE
                }
                3 -> {
                    coins3.visibility = View.VISIBLE
                }
                4 -> {
                    coins4.visibility = View.VISIBLE
                }
                5 -> {
                    coins5.visibility = View.VISIBLE
                }
                6 -> {
                    coins6.visibility = View.VISIBLE
                }
                7 -> {
                    coins7.visibility = View.VISIBLE
                }
                8 -> {
                    coins8.visibility = View.VISIBLE
                }
                9 -> {
                    coins9.visibility = View.VISIBLE
                }
                10 -> {
                    coins10.visibility = View.VISIBLE
                }
                11 -> {
                    coins11.visibility = View.VISIBLE
                }
                12 -> {
                    coins12.visibility = View.VISIBLE
                }
                13 -> {
                    coins13.visibility = View.VISIBLE
                }
                14 -> {
                    coins14.visibility = View.VISIBLE
                }
                15 -> {
                    coins15.visibility = View.VISIBLE
                }
                16 -> {
                    coins16.visibility = View.VISIBLE
                }
                17 -> {
                    coins17.visibility = View.VISIBLE
                }
                18 -> {
                    coins18.visibility = View.VISIBLE
                }
                19 -> {
                    coins19.visibility = View.VISIBLE
                }
                20 -> {
                    coins20.visibility = View.VISIBLE
                }
            }
        }



        /*     var coins1_player_x = findViewById<ImageView>(R.id.coins1_player_x)
             coins1_player_x.visibility = View.VISIBLE*/
    }

    fun showCoinsDouble() {
        var coins1_player = findViewById<ImageView>(R.id.coins1_player)
        var coins2_player = findViewById<ImageView>(R.id.coins2_player)
        var coins3_player = findViewById<ImageView>(R.id.coins3_player)
        var coins4_player = findViewById<ImageView>(R.id.coins4_player)

        DoubleActive = true

        coins -= 2
        showCoins()
// sorry I put them out in showcoins
        coins1_player.visibility = View.VISIBLE
        coins2_player.visibility = View.VISIBLE
        coins3_player.visibility = View.VISIBLE
        coins4_player.visibility = View.VISIBLE
    }

    fun showCardStandBtnLeft(){
        var cardsBtn = findViewById<Button>(R.id.cardsBtn)
        var standBtn = findViewById<Button>(R.id.standBtn)

        cardsBtn.visibility = View.VISIBLE
        standBtn.visibility = View.VISIBLE
    }
    fun CardStandBtnLeftInvisible(){
        var cardsBtn = findViewById<Button>(R.id.cardsBtn)
        var standBtn = findViewById<Button>(R.id.standBtn)

        cardsBtn.visibility = View.INVISIBLE
        standBtn.visibility = View.INVISIBLE
    }

    fun showCardStandBtnRight(){
        var cards2Btn = findViewById<Button>(R.id.cards2Btn)
        var stand2Btn = findViewById<Button>(R.id.stand2Btn)

        cards2Btn.visibility = View.VISIBLE
        stand2Btn.visibility = View.VISIBLE
    }


    fun showCoinsSplit_right() {
        var coins1_player2 = findViewById<ImageView>(R.id.coins1_player2)
        var coins2_player2 = findViewById<ImageView>(R.id.coins2_player2)

        coins1_player2.visibility = View.VISIBLE
        coins2_player2.visibility = View.VISIBLE
    }

        fun splitDoubleBtnInvisible() {
            var double_Btn = findViewById<Button>(R.id.doubleBtn)
            var splitButton = findViewById<Button>(R.id.splitBtn)
            splitButton.visibility = View.INVISIBLE
            double_Btn.visibility = View.INVISIBLE
        }

    fun showCoinsSplit() {

   //     linearLayoutRight

        var coins1_player2 = findViewById<ImageView>(R.id.coins1_player2)
        var coins2_player2 = findViewById<ImageView>(R.id.coins2_player2)


        var right_down_card1 = findViewById<ImageView>(R.id.rightDownCard1)
        var right_down_card2 = findViewById<ImageView>(R.id.rightDownCard2)
        var linearLayoutRight = findViewById<LinearLayout>(R.id.linearLayoutRight)
        var playerFlipCards2LL = findViewById<LinearLayout>(R.id.playerFlipCards2LL)

        var double_Btn = findViewById<Button>(R.id.doubleBtn)
        var splitButton = findViewById<Button>(R.id.splitBtn)
        var flip_card1_split = findViewById<ImageView>(R.id.flipCard1_split)
        var flip_card2_split = findViewById<ImageView>(R.id.flipCard2_split)
        var flip_card3_split = findViewById<ImageView>(R.id.flipCard3_split)
      //  var flip_card4_split = findViewById<ImageView>(R.id.flipCard4_split)



        flip_card1_split.visibility = View.VISIBLE
        flip_card2_split.visibility = View.VISIBLE
        flip_card3_split.visibility = View.VISIBLE
   //     flip_card4_split.visibility = View.VISIBLE

        playerFlipCards2LL.visibility = View.VISIBLE

        right_down_card1.visibility = View.VISIBLE
        right_down_card2.visibility = View.VISIBLE


        linearLayoutRight.visibility = View.VISIBLE
        splitDoubleBtnInvisible()

        coins -= 2

        weAreInSplit = true
        showCoins()
        showPlayerCoins()

        // because I put them out in showCoins
        showCoinsSplit_right()
    }

    // Custom method to get assets folder image as bitmap
    private fun getBitmapFromAssets(fileName: String): Bitmap? {
        return try {
            BitmapFactory.decodeStream(assets.open(fileName))
            //      BitmapFactory.decodeStream(res.open(fileName))
            //       BitmapFactory.decodeStream(drawable.open(fileName))
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }

    // change color of an ImageView
    private fun setColorOfAnImageView(imgView: ImageView, transparency: Int) {
        imgView.setColorFilter(Color.argb(transparency, 0, 0, 0))
    }

    private fun countdown() {

        object : CountDownTimer(4000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {

                //            testar()
            }
        }.start()
    }

    var secondcard = false



    private fun countdownOne() {
        var flip_dealercard2 = findViewById<ImageView>(R.id.dealercard2)
        var flip_dealercard3 = findViewById<ImageView>(R.id.dealercard3)
        var flip_dealercard4 = findViewById<ImageView>(R.id.dealercard4)
        var flip_dealercard5 = findViewById<ImageView>(R.id.dealercard5)
        var addupdealer1 = findViewById<TextView>(R.id.addUpDealer1)
        var dealerBlackJack = false

     //   var addupdealer2 = findViewById<TextView>(R.id.addUpDealer2)


        var addPlayerCards1 = findViewById<TextView>(R.id.addUpPlayerHigh)
        var addPlayerCards2 = findViewById<TextView>(R.id.addUpPlayer2High)
      //  var stackOfCoins = findViewById<TextView>(R.id.stack)

        blockEveryBtn = true


      //  addupdealer2.text = "start"

        object : CountDownTimer(1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {

                randomCardsIntValue = cardArray.getOneRandomCardsValue()

                if (randomCardsIntValue == null)
                {
         //           Toast.makeText(it, "Shuffle", Toast.LENGTH_LONG).show()
        /*            val snack = Snackbar.make(this, "Shuffle", Snackbar.LENGTH_INDEFINITE)
                    snack.setAction("Jepp")
                    {

                    }
                    snack.show()*/
                }

// fusk testa att lägga 2 ess
        //        dealerCards.add(2)
                if (cheat)
                {
                    dealerCards.add(5)
                }
                else
                {
                    dealerCards.add(randomCardsIntValue[0].value)
                }

                flip_dealercard2.setImageDrawable(getDrawable(randomCardsIntValue[0].name))

                if (true) {
                    var sum = dealerCards[0] + dealerCards[1]

                    // if two ace
                    if (sum == 22){
                        sum = sum -10
                    }

                    if (sum == 21){
                        dealerBlackJack = true
                    }

                    addupdealer1.text = (sum).toString()

  //                  addupdealer2.text = ""

                    if (sum > 21) {
                        addupdealer1.setBackgroundColor(Color.RED)
                        dealerNoMoreCards = 2
     //                   addupdealer2.text = "Player wins33"
                        // fast kolla dubbel
                        if (!playerLeftBlackJack) {
                            if (DoubleActive)
                            {
                                coins += 8
                            }else
                            {
                                coins += 4
                            }

                        }

                        // check if bust
                        if (weAreInSplit)
                        {
                            if (!playerRightBlackJack) {
                                coins += 4
                            }
                        }

                        showCoins()
                     //   showCoinsX_right_invisible()
                        stack = stack + 100
    //                    stackOfCoins.text = stack.toString()

                    } else
                    {
                        if (sum >= 17) {
      //                      addupdealer2.text = "Dealer has to stand"
                            dealerNoMoreCards = 2
                           // var sumdealer = dealerCards[0] + dealerCards[1]

                            showDealPlaySum(sum, sumplayer)

/// det blev player wins.

                            if ((sum > sumplayer) || (sumplayer > 21)){
        //                        addupdealer2.text = "Dealer wins11"
                                stack = stack - 100
            //                    stackOfCoins.text = stack.toString()

                                //    showCoinsX_right()

                                showCoinsX2()
                            } else
                            {
                                if (sum == sumplayer) {
         //                           addupdealer2.text = "Split Pot" // put money back
                                    // fast kolla dubbel
                                        if (dealerBlackJack == true)
                                        {
                                            if (playerLeftBlackJack){
                                                // get 3 coins back
                                      //          Toast.makeText(it, "Sorry, tar tillbaka pengar", Toast.LENGTH_LONG).show()
                                 /*               val snack = Snackbar.make(requireActivity(), "Inte en siffra", Snackbar.LENGTH_INDEFINITE)
                                                snack.setAction("Jepp")
                                                {

                                                }
                                                snack.show() */

                                                coins -= 3
                                                showCoins()
                                            }
                                            else
                                            {
                                                showCoinsX2()
                                            }

                                        }else
                                        {
                                            //coins += 2
                                            if (DoubleActive)
                                            {
                                                coins += 4
                                            }else
                                            {
                                                coins += 2
                                            }
                                            showCoins()
                                        }

                                //    showCoins()
                                } else {
             //                       addupdealer2.text = "Player wins44"
                                    stack = stack + 100
             //                       stackOfCoins.text = stack.toString()
                                    // fast kolla dubbel
                                    if (!playerLeftBlackJack) {
                                       // coins += 4
                                        if (DoubleActive)
                                        {
                                            coins += 8
                                        }else
                                        {
                                            coins += 4
                                        }
                                    }
                                    showCoins()
                                }
                            }

                            if (weAreInSplit) {
                                if ((sum > sumplayer_split) || (sumplayer_split > 21)){
            //                        addupdealer2.text = "Dealer wins22"
                                    stack = stack - 100
             //                       stackOfCoins.text = stack.toString()

                                    // va ??
                                    if (!playerRightToMuch) {
                                        showCoinsX_right()
                                    }

                                    //  showCoinsX()
                                } else
                                {
                                    if (sum == sumplayer_split) {
             //                           addupdealer2.text = "Split Pot" // put money back
                                        // fast kolla dubbel
                                      //  coins += 2
                                        if (dealerBlackJack == true)
                                        {
                                            if (playerRightBlackJack){
                                                // get 3 coins back
                                              //  Toast.makeText(it, "Sorry, tar tillbaka pengar", Toast.LENGTH_LONG).show()
                                                coins -= 3
                                                showCoins()
                                            }
                                            else{
                                                showCoinsX_right()
                                            }

                                        }else
                                        {
                                            coins += 2
                                            showCoins()
                                        }
                                    //    showCoins()
                                    } else {
              //                          addupdealer2.text = "Player wins"
                                        stack = stack + 100
              //                          stackOfCoins.text = stack.toString()
                                        // fast kolla dubbel
                                        if (!playerRightBlackJack) {
                                            coins += 4
                                        }
                                        showCoins()
                                    }
                                }
                            }
                            // check left side and right
                            return

                        }
                    }
                }
                secondcard = true
                countdownTwo()
            }
        }.start()
    }

    private fun countdownTwo() {
        var flip_dealercard2 = findViewById<ImageView>(R.id.dealercard2)
        var flip_dealercard3 = findViewById<ImageView>(R.id.dealercard3)
        var flip_dealercard4 = findViewById<ImageView>(R.id.dealercard4)
        var flip_dealercard5 = findViewById<ImageView>(R.id.dealercard5)
        var addupdealer1 = findViewById<TextView>(R.id.addUpDealer1)

   //     var addupdealer2 = findViewById<TextView>(R.id.addUpDealer2)

        var addPlayerCards1 = findViewById<TextView>(R.id.addUpPlayerHigh)
        var addPlayerCards2 = findViewById<TextView>(R.id.addUpPlayer2High)
  //      var stackOfCoins = findViewById<TextView>(R.id.stack)

     //   addupdealer2.text = "start"
            //  if (secondcard) {
            object : CountDownTimer(1000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                }

                override fun onFinish() {
                    if (dealerNoMoreCards != 0) {
                        return
                    }


                    randomCardsIntValue = cardArray.getOneRandomCardsValue()

                    if (randomCardsIntValue == null)
                    {
                   /*     Toast.makeText(this, "Shuffle", Toast.LENGTH_LONG).show()
                        val snack = Snackbar.make(this, "Shuffle", Snackbar.LENGTH_INDEFINITE)
                        snack.setAction("Jepp")
                        {

                        }
                        snack.show()*/
                    }
                  //  dealerCards.add(randomCardsIntValue[0].value)
                    flip_dealercard3.setImageDrawable(getDrawable(randomCardsIntValue[0].name))

                    // fusk
         //           dealerCards.add(2)
                    if (cheat)
                    {
                        dealerCards.add(10)
                    }
                    else
                    {
                        dealerCards.add(randomCardsIntValue[0].value)
                    }

                        var sum = dealerCards[0] + dealerCards[1] + dealerCards[2]

                    /*    if (sum > 21) {
                            if (dealerCards[0] == 11 || dealerCards[1] == 11 || dealerCards[2] == 11) {
                                sum = dealerCards[0] + dealerCards[1] + dealerCards[2] - 10
                            }
                        }*/

                        var countAce = 0
                        for (i in 0..dealerCards.size - 1)
                        {
                            if (dealerCards[i] == 11)
                            {
                               countAce++
                            }
                        }
                /*        if (countAce > 1)
                        {
                            sum = sum - (countAce-1)* 10
                        }*/

                    if (countAce > 1){

                        sum = sum - (countAce-1)* 10
                        if(sum > 21){
                            sum = dealerCards[0] + dealerCards[1] + dealerCards[2]
                            sum = sum - countAce*10
                        }
                    }
                    if (countAce == 1){
                        if(sum > 21){
                            sum = dealerCards[0] + dealerCards[1] + dealerCards[2]
                            sum = sum - countAce*10
                        }
                    }
                    // men möjligen även check om jag är över 16

                        addupdealer1.text = (sum).toString()

    //                    addupdealer2.text = ""


                        if (sum > 21)
                        {
                            addupdealer1.setBackgroundColor(Color.RED)
     //                       addupdealer2.text = "Dealer to high"

      //                      addupdealer2.text = "Player wins"
                            stack = stack + 100
      //                      stackOfCoins.text = stack.toString()
                            dealerNoMoreCards = 3
                            // fast kolla dubbel
                            if (!playerLeftToMuch) {
                                if (!playerLeftBlackJack) {
                                    //           coins += 4
                                    if (DoubleActive) {
                                        coins += 8
                                    } else {
                                        coins += 4
                                    }
                                }
                            }

                            // check if bust
                            if (weAreInSplit)
                            {
                                if (!playerRightToMuch) {
                                    if (!playerRightBlackJack) {
                                        coins += 4
                                    }
                                }
                            }

                            showCoins()

                            // kolla både left och right
                            return
                        } else {
                            if (sum >= 17) {
                                dealerNoMoreCards = 3
    //                            addupdealer2.text = "Dealer has to stand"

                      //          var sumdealer = dealerCards[0] + dealerCards[1] + dealerCards[2]

                                showDealPlaySum(sum, sumplayer)

                                if ((sum > sumplayer) || (sumplayer > 21)){
                          //      if (sum > sumplayer) {
         //                           addupdealer2.text = "Dealer wins"
                                    stack = stack - 100
          //                          stackOfCoins.text = stack.toString()
                                    //         showCoinsX_right()
                                    showCoinsX2()
                                } else {
                                    if (sum == sumplayer) {
         //                               addupdealer2.text = "Split Pot" // put money back
                                        // fast kolla dubbel
                                            // Dealer has 3 cards and if we have a black jack, then we have already given
                                        if (!playerLeftBlackJack) {
                                            if (DoubleActive) {
                                                coins += 4
                                            } else {
                                                coins += 2
                                            }
                                        }
                                       // coins += 2
                                        showCoins()
                                    } else {
            //                            addupdealer2.text = "Player wins"
                                        stack = stack + 100
              //                          stackOfCoins.text = stack.toString()
                                        // fast kolla dubbel
                                        if (!playerLeftBlackJack) {
                                          //  coins += 4
                                            if (DoubleActive)
                                            {
                                                coins += 8
                                            }else
                                            {
                                                coins += 4
                                            }
                                        }
                                        showCoins()
                                    }
                                }
                                if (weAreInSplit) {
                            //        if (sum > sumplayer_split) {
                                    if ((sum > sumplayer_split) || (sumplayer_split > 21)){
              //                          addupdealer2.text = "Dealer wins55"
                                        stack = stack - 100
             //                           stackOfCoins.text = stack.toString()
                              // already shown                   showCoinsX_right()
                                       // showCoinsX()
                                        if (!playerRightToMuch) {
                                            showCoinsX_right()
                                        }
                                    } else {
                                        if (sum == sumplayer_split) {
              //                              addupdealer2.text = "Split Pot" // put money back
                                            // fast kolla dubbel
                                            // Dealer has 3 cards and if we have a black jack, then we have already given
                                            if (!playerRightBlackJack) {
                                                coins += 2
                                            }
                                            showCoins()
                                        } else {
             //                               addupdealer2.text = "Player wins"
                                            stack = stack + 100
             //                               stackOfCoins.text = stack.toString()
                                            // fast kolla dubbel
                                            if (!playerRightBlackJack) {
                                                coins += 4
                                            }
                                            showCoins()
                                        }
                                    }
                                }

     //                           addPlayerCards2.text = addPlayerCards1.text

                                return

                            }
                        }


       /*             if (weAreInSplit) {
                        var sum = dealerCards[0] + dealerCards[1] + dealerCards[2]

                        if (sum > 21) {
                            if (dealerCards[0] == 11 || dealerCards[1] == 11 || dealerCards[2] == 11) {
                                sum = dealerCards[0] + dealerCards[1] + dealerCards[2] - 10
                            }
                        }

                        addupdealer1.text = (sum).toString()

                        addupdealer2.text = ""


                        if (sum > 21) {
                            addupdealer1.setBackgroundColor(Color.RED)
                            addupdealer2.text = "Dealer to high"

                            addupdealer2.text = "Player wins"
                            stack = stack + 100
                            stackOfCoins.text = stack.toString()
                            dealerNoMoreCards = 3

                            return
                        } else {
                            if (sum >= 17) {
                                dealerNoMoreCards = 3
                                addupdealer2.text = "Dealer has to stand"

                                var sumdealer = dealerCards[0] + dealerCards[1] + dealerCards[2]

                                showDealPlaySum(sumdealer, sumplayer)

                                if (sumdealer > sumplayer) {
                                    addupdealer2.text = "Dealer wins"
                                    stack = stack - 100
                                    stackOfCoins.text = stack.toString()
                                    //         showCoinsX_right()
                                    showCoinsX()
                                } else {
                                    if (sumdealer == sumplayer) {
                                        addupdealer2.text = "Split Pot" // put money back
                                    } else {
                                        addupdealer2.text = "Player wins"
                                        stack = stack + 100
                                        stackOfCoins.text = stack.toString()
                                    }
                                }

                                addPlayerCards2.text = addPlayerCards1.text

                                return
                            }
                        }
                    }*/


       // ojdå             if (addupdealer2.text == ""){
                        secondcard = true
                        countdownThree()
           //         }

                }
            }.start()

    }

    private fun countdownThree() {
        var flip_dealercard2 = findViewById<ImageView>(R.id.dealercard2)
        var flip_dealercard3 = findViewById<ImageView>(R.id.dealercard3)
        var flip_dealercard4 = findViewById<ImageView>(R.id.dealercard4)
        var flip_dealercard5 = findViewById<ImageView>(R.id.dealercard5)
        var addupdealer1 = findViewById<TextView>(R.id.addUpDealer1)

   //     var addupdealer2 = findViewById<TextView>(R.id.addUpDealer2)

        var addPlayerCards1 = findViewById<TextView>(R.id.addUpPlayerHigh)
        var addPlayerCards2 = findViewById<TextView>(R.id.addUpPlayer2High)
   //     var stackOfCoins = findViewById<TextView>(R.id.stack)


    //    addupdealer2.text = "start"


        object : CountDownTimer(1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
            }

            override fun onFinish() {
                if (dealerNoMoreCards != 0) {
                    return
                }

                randomCardsIntValue = cardArray.getOneRandomCardsValue()

                if (randomCardsIntValue == null)
                {
                /*    Toast.makeText(this, "Shuffle", Toast.LENGTH_LONG).show()
                    val snack = Snackbar.make(this, "Shuffle", Snackbar.LENGTH_INDEFINITE)
                    snack.setAction("Jepp")
                    {

                    }
                    snack.show()*/
                }
              //  dealerCards.add(randomCardsIntValue[0].value)

                // fusk
     //           dealerCards.add(2)

                if (cheat)
                {
                    dealerCards.add(10)
                }
                else
                {
                    dealerCards.add(randomCardsIntValue[0].value)
                }

                // jag kommer inte ihåg varför jag kollar tre kort igen
//--------------------------- kan det tas bort ?
                var sum = dealerCards[0] + dealerCards[1] + dealerCards[2]

                /*if (sum > 21) {
                    if (dealerCards[0] == 11 || dealerCards[1] == 11 || dealerCards[2] == 11) {
                        sum = dealerCards[0] + dealerCards[1] + dealerCards[2] - 10
                    }
                }*/
                var countAce = 0
                for (i in 0..dealerCards.size - 1)
                {
                    if (dealerCards[i] == 11)
                    {
                        countAce++
                    }
                }
            /*    if (countAce > 1)
                {
                    sum = sum - (countAce-1)* 10
                }*/
                if (countAce > 1){

                    sum = sum - (countAce-1)* 10
                    if(sum > 21){
                        sum = dealerCards[0] + dealerCards[1] + dealerCards[2]
                        sum = sum - countAce*10
                    }
                }
                if (countAce == 1){
                    if(sum > 21){
                        sum = dealerCards[0] + dealerCards[1] + dealerCards[2]
                        sum = sum - countAce*10
                    }
                }

                // kolla om vi är över 16

// Vi behöver nog inte ha detta
                if (sum > 21) {
                    addupdealer1.setBackgroundColor(Color.RED)
    //                addupdealer2.text = "Dealer to high"

     //               addupdealer2.text = "Player wins"
                    stack = stack + 100
     //               stackOfCoins.text = stack.toString()
                    dealerNoMoreCards = 3
                    // fast kolla dubbel
                    if (!playerLeftToMuch) {
                        if (!playerLeftBlackJack) {
                            //   coins += 4
                            if (DoubleActive) {
                                coins += 8
                            } else {
                                coins += 4
                            }
                        }
                    }
                  //  coins += 4

                    // check if bust
                    if (weAreInSplit)
                    {
          //              coins += 4
                        if (!playerRightToMuch) {
                            if (!playerRightBlackJack) {
                                coins += 4
                            }
                        }
                    }

                    showCoins()
                    // kolla left, kolla right
                    return
                } else {
                    if (sum >= 17) {
                        //      Toast.makeText(this, "Dealer has to stand", Toast.LENGTH_LONG).show()
    //                    addupdealer2.text = "Dealer has to stand"
                        dealerNoMoreCards = 3
         //               var sumdealer = dealerCards[0] + dealerCards[1] + dealerCards[2]

                        /*    var sumplayer = 0
                        for (i in 0..flipCardNumber+2) {
                            sumplayer += playerCards[i]
                        }*/

                        showDealPlaySum(sum, sumplayer)

          //              if (sum > sumplayer) {
                        if ((sum > sumplayer) || (sumplayer > 21)){
     //                       addupdealer2.text = "Dealer wins"
                            stack = stack - 100
      //                      stackOfCoins.text = stack.toString()
                      //      showCoinsX_right()
                            showCoinsX2()
                        } else {
                            if (sum == sumplayer) {
         //                       addupdealer2.text = "Split Pot" // put money back
                                // fast kolla dubbel
                             //   coins += 2
                                // Dealer has 3 cards and if we have a black jack, then we have already given
                                if (!playerLeftBlackJack) {
                                    if (DoubleActive) {
                                        coins += 4
                                    } else {
                                        coins += 2
                                    }
                                }
                                showCoins()
                            } else {
          //                      addupdealer2.text = "Player wins"
                                stack = stack + 100
         //                       stackOfCoins.text = stack.toString()
                                // fast kolla dubbel
                                if (!playerLeftBlackJack) {
                                  //  coins += 4
                                    if (DoubleActive)
                                    {
                                        coins += 8
                                    }else
                                    {
                                        coins += 4
                                    }
                                }
                        //        coins += 4
                                showCoins()
                            }
                        }
                        if (weAreInSplit) {
                         //   if (sum > sumplayer_split) {
                            if ((sum > sumplayer_split) || (sumplayer_split > 21)){
          //                      addupdealer2.text = "Dealer wins"
                                stack = stack - 100
          //                      stackOfCoins.text = stack.toString()
                     // already shown                 showCoinsX_right()
                         //       showCoinsX()
                                if (!playerRightToMuch) {
                                    showCoinsX_right()
                                }
                            } else {
                                if (sum == sumplayer_split) {
             //                       addupdealer2.text = "Split Pot" // put money back
                                    // fast kolla dubbel
                                    // Dealer has 3 cards and if we have a black jack, then we have already given
                                    if (!playerRightBlackJack) {
                                        coins += 2
                                    }
                                    showCoins()
                                } else {
            //                        addupdealer2.text = "Player wins"
                                    stack = stack + 100
             //                       stackOfCoins.text = stack.toString()
                                    // fast kolla dubbel

                                    // we have already handed 1.5
                                    if (!playerRightBlackJack) {
                                        coins += 4
                                    }
                                    showCoins()
                                }
                            }
                        }

  //                      addPlayerCards2.text = addPlayerCards1.text


                        return
                    }
                }

                flip_dealercard4.setImageDrawable(getDrawable(randomCardsIntValue[0].name))

                if (true) {

                    sum = dealerCards[0] + dealerCards[1] + dealerCards[2] + dealerCards[3]

                  /*  if (sum > 21) {
                        if (dealerCards[0] == 11 || dealerCards[1] == 11 || dealerCards[2] == 11 || dealerCards[3] == 11) {
                            sum =
                                dealerCards[0] + dealerCards[1] + dealerCards[2] + dealerCards[3] - 10
                        }
                    }*/
                    var countAce = 0
                    for (i in 0..dealerCards.size - 1)
                    {
                        if (dealerCards[i] == 11)
                        {
                            countAce++
                        }
                    }
                  /*  if (countAce > 1)
                    {
                        sum = sum - (countAce-1)* 10
                    }*/
                    if (countAce > 1){

                        sum = sum - (countAce-1)* 10
                        if(sum > 21){
                            sum = dealerCards[0] + dealerCards[1] + dealerCards[2] + dealerCards[3]
                            sum = sum - countAce*10
                        }
                    }
                    if (countAce == 1){
                        if(sum > 21){
                            sum = dealerCards[0] + dealerCards[1] + dealerCards[2] + dealerCards[3]
                            sum = sum - countAce*10
                        }
                    }

                    addupdealer1.text = (sum).toString()

       //             addupdealer2.text = ""



                    if (sum > 21) {
                        addupdealer1.setBackgroundColor(Color.RED)
         //               addupdealer2.text = "Dealer to high"

          //              addupdealer2.text = "Player wins"
                        stack = stack + 100
         //               stackOfCoins.text = stack.toString()
                        dealerNoMoreCards = 4
                        // fast kolla dubbel
                        //   coins += 4
                        if (!playerLeftToMuch) {
                            if (!playerLeftBlackJack) {
                                //    coins += 4
                                if (DoubleActive) {
                                    coins += 8
                                } else {
                                    coins += 4
                                }
                            }
                        }

                        // check if bust
                        if (weAreInSplit)
                        {
         //                   coins += 4 must check fat
                            if (!playerRightToMuch) {
                                if (!playerRightBlackJack) {
                                    coins += 4
                                }
                            }
                        }


                        showCoins()

                        return
                    } else {
                        if (sum >= 17) {
                            //      Toast.makeText(this, "Dealer has to stand", Toast.LENGTH_LONG).show()
                            dealerNoMoreCards = 4
     //                       addupdealer2.text = "Dealer has to stand"
                //            var sumdealer =
                                dealerCards[0] + dealerCards[1] + dealerCards[2] + dealerCards[3]

                            /*      var sumplayer = 0
                        for (i in 0..flipCardNumber+2) {
                            sumplayer += playerCards[i]
                        }*/

                            showDealPlaySum(sum, sumplayer)

                    //        if (sum > sumplayer) {
                            if ((sum > sumplayer) || (sumplayer > 21)){
          //                      addupdealer2.text = "Dealer wins"
                                stack = stack - 100
        //                        stackOfCoins.text = stack.toString()
                                //     showCoinsX_right()
                                showCoinsX2()
                            } else {
                                if (sum == sumplayer) {
         //                           addupdealer2.text = "Split Pot"  // put money back
                                    // fast kolla dubbel
                                   // coins += 2
                                    // Dealer has 3 cards and if we have a black jack, then we have already given
                                    if (!playerLeftBlackJack) {
                                        if (DoubleActive) {
                                            coins += 4
                                        } else {
                                            coins += 2
                                        }
                                    }
                                    showCoins()
                                } else {
         //                           addupdealer2.text = "Player wins"
                                    stack = stack + 100
          //                          stackOfCoins.text = stack.toString()
                                    // fast kolla dubbel
                              //      coins += 4
                                    if (!playerLeftBlackJack) {
                                     //   coins += 4
                                        if (DoubleActive)
                                        {
                                            coins += 8
                                        }else
                                        {
                                            coins += 4
                                        }
                                    }
                                    showCoins()
                                }
                            }
                            if (weAreInSplit) {
                          //      if (sum > sumplayer_split) {
                                if ((sum > sumplayer_split) || (sumplayer_split > 21)){
         //                           addupdealer2.text = "Dealer wins"
                                    stack = stack - 100
         //                           stackOfCoins.text = stack.toString()
                     // already shown                    showCoinsX_right()
                               //     showCoinsX()
                                    if (!playerRightToMuch) {
                                        showCoinsX_right()
                                    }
                                } else {
                                    if (sum == sumplayer_split) {
             //                           addupdealer2.text = "Split Pot"  // put money back
                                        // fast kolla dubbel
                                        // Dealer has 3 cards and if we have a black jack, then we have already given
                                        if (!playerRightBlackJack) {
                                            coins += 2
                                        }
                                        showCoins()
                                    } else {
              //                          addupdealer2.text = "Player wins"
                                        stack = stack + 100
            //                            stackOfCoins.text = stack.toString()
                                        // fast kolla dubbel

                                        if (!playerRightBlackJack) {
                                            coins += 4
                                        }
                                  //      coins += 4
                                        showCoins()
                                    }
                                }
                            }

          //                  addPlayerCards2.text = addPlayerCards1.text

                            return
                        }
                    }
                }

     /*           if (weAreInSplit) {

                    sum = dealerCards[0] + dealerCards[1] + dealerCards[2] + dealerCards[3]

                    if (sum > 21) {
                        if (dealerCards[0] == 11 || dealerCards[1] == 11 || dealerCards[2] == 11 || dealerCards[3] == 11) {
                            sum =
                                dealerCards[0] + dealerCards[1] + dealerCards[2] + dealerCards[3] - 10
                        }
                    }

                    addupdealer1.text = (sum).toString()

                    addupdealer2.text = ""



                    if (sum > 21) {
                        addupdealer1.setBackgroundColor(Color.RED)
                        addupdealer2.text = "Dealer to high"

                        addupdealer2.text = "Player wins"
                        stack = stack + 100
                        stackOfCoins.text = stack.toString()
                        dealerNoMoreCards = 4

                        return
                    } else {
                        if (sum >= 17) {
                            //      Toast.makeText(this, "Dealer has to stand", Toast.LENGTH_LONG).show()
                            dealerNoMoreCards = 4
                            addupdealer2.text = "Dealer has to stand"
                            var sumdealer =
                                dealerCards[0] + dealerCards[1] + dealerCards[2] + dealerCards[3]

                            /*      var sumplayer = 0
                        for (i in 0..flipCardNumber+2) {
                            sumplayer += playerCards[i]
                        }*/

                            showDealPlaySum(sumdealer, sumplayer)

                            if (sumdealer > sumplayer) {
                                addupdealer2.text = "Dealer wins"
                                stack = stack - 100
                                stackOfCoins.text = stack.toString()
                                //     showCoinsX_right()
                                showCoinsX()
                            } else {
                                if (sumdealer == sumplayer) {
                                    addupdealer2.text = "Split Pot"  // put money back
                                } else {
                                    addupdealer2.text = "Player wins"
                                    stack = stack + 100
                                    stackOfCoins.text = stack.toString()
                                }
                            }

                            addPlayerCards2.text = addPlayerCards1.text

                            return
                        }
                    }
                }*/

 //ojdå               if (addupdealer2.text == ""){
                    secondcard = true
                    countdownFour()
     //           }

            }
        }.start()

    }

    private fun countdownFour() {
        var flip_dealercard2 = findViewById<ImageView>(R.id.dealercard2)
        var flip_dealercard3 = findViewById<ImageView>(R.id.dealercard3)
        var flip_dealercard4 = findViewById<ImageView>(R.id.dealercard4)
        var flip_dealercard5 = findViewById<ImageView>(R.id.dealercard5)
        var addupdealer1 = findViewById<TextView>(R.id.addUpDealer1)


    //    var addupdealer2 = findViewById<TextView>(R.id.addUpDealer2)


        var addPlayerCards1 = findViewById<TextView>(R.id.addUpPlayerHigh)
        var addPlayerCards2 = findViewById<TextView>(R.id.addUpPlayer2High)
   //     var stackOfCoins = findViewById<TextView>(R.id.stack)




 //       addupdealer2.text = "start"


        object : CountDownTimer(1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
            }

            override fun onFinish() {
                if (dealerNoMoreCards != 0) {
                    return
                }

                randomCardsIntValue = cardArray.getOneRandomCardsValue()

                if (randomCardsIntValue == null)
                {
            /*        Toast.makeText(this, "Shuffle", Toast.LENGTH_LONG).show()
                    val snack = Snackbar.make(this, "Shuffle", Snackbar.LENGTH_INDEFINITE)
                    snack.setAction("Jepp")
                    {

                    }
                    snack.show()*/
                }
          //      dealerCards.add(randomCardsIntValue[0].value)
// fusk
     //           dealerCards.add(2)
                if (cheat)
                {
                    dealerCards.add(10)
                }
                else
                {
                    dealerCards.add(randomCardsIntValue[0].value)
                }

// samma här, varför kollar jag fyra igen
// -------------------------------
                var sum = dealerCards[0] + dealerCards[1] + dealerCards[2] + dealerCards[3]

                /*if (sum > 21) {
                    if (dealerCards[0] == 11 || dealerCards[1] == 11 || dealerCards[2] == 11 || dealerCards[3] == 11) {
                        sum =
                            dealerCards[0] + dealerCards[1] + dealerCards[2] + dealerCards[3] - 10
                    }
                }*/

                var countAce = 0
                for (i in 0..dealerCards.size - 1)
                {
                    if (dealerCards[i] == 11)
                    {
                        countAce++
                    }
                }
             /*   if (countAce > 1)
                {
                    sum = sum - (countAce-1)* 10
                }*/
                if (countAce > 1){

                    sum = sum - (countAce-1)* 10
                    if(sum > 21){
                        sum = dealerCards[0] + dealerCards[1] + dealerCards[2] + dealerCards[3]
                        sum = sum - countAce*10
                    }
                }
                if (countAce == 1){
                    if(sum > 21){
                        sum = dealerCards[0] + dealerCards[1] + dealerCards[2] + dealerCards[3]
                        sum = sum - countAce*10
                    }
                }

                // kolla om vi är över 16

                if (sum > 21) {
                    addupdealer1.setBackgroundColor(Color.RED)
     //               addupdealer2.text = "Dealer to high"

     //               addupdealer2.text = "Player wins"
                    stack = stack + 100
     //               stackOfCoins.text = stack.toString()
                    dealerNoMoreCards = 4
                    // fast kolla dubbel
                    if (!playerLeftToMuch) {
                        if (!playerLeftBlackJack) {
                            //    coins += 4
                            if (DoubleActive) {
                                coins += 8
                            } else {
                                coins += 4
                            }
                        }
                    }
                //    coins += 4

                    // check if bust
                    if (weAreInSplit)
                    {
                        if (!playerRightToMuch) {
                            if (!playerRightBlackJack) {
                                coins += 4
                            }
                        }
                  //      coins += 4
                    }


                    showCoins()

                    return
                } else {
                    if (sum >= 17) {
                        //      Toast.makeText(this, "Dealer has to stand", Toast.LENGTH_LONG).show()
        //                addupdealer2.text = "Dealer has to stand"
                        dealerNoMoreCards = 4

               //         var sumdealer =
                      //      dealerCards[0] + dealerCards[1] + dealerCards[2] + dealerCards[3]

                        /*     var sumplayer = 0
                        for (i in 0..flipCardNumber+2) {
                            sumplayer += playerCards[i]
                        }*/

                        showDealPlaySum(sum, sumplayer)

                    //    if (sum > sumplayer) {
                        if ((sum > sumplayer) || (sumplayer > 21)){
         //                   addupdealer2.text = "Dealer wins"
                            stack = stack - 100
         //                   stackOfCoins.text = stack.toString()

                     //       showCoinsX_right()
                            showCoinsX2()
                        } else {
                            if (sum == sumplayer) {
        //                        addupdealer2.text = "Split Pot" // put money back
                                // fast kolla dubbel
                          //      coins += 2
                                // Dealer has 3 cards and if we have a black jack, then we have already given
                                if (!playerLeftBlackJack) {
                                    if (DoubleActive) {
                                        coins += 4
                                    } else {
                                        coins += 2
                                    }
                                }
                                showCoins()
                            } else {
          //                      addupdealer2.text = "Player wins"
                                stack = stack + 100
          //                      stackOfCoins.text = stack.toString()
                                // fast kolla dubbel
                                if (!playerLeftBlackJack) {
                                //    coins += 4
                                    if (DoubleActive)
                                    {
                                        coins += 8
                                    }else
                                    {
                                        coins += 4
                                    }
                                }
                      //          coins += 4
                                showCoins()
                            }
                        }

                        if (weAreInSplit) {
                     //       if (sum > sumplayer_split) {
                            if ((sum > sumplayer_split) || (sumplayer_split > 21)){
         //                       addupdealer2.text = "Dealer wins"
                                stack = stack - 100
          //                      stackOfCoins.text = stack.toString()

                  // already shown                     showCoinsX_right()
                          //      showCoinsX()
                                if (!playerRightToMuch) {
                                    showCoinsX_right()
                                }
                            } else {
                                if (sum == sumplayer_split) {
         //                           addupdealer2.text = "Split Pot" // put money back
                                    // fast kolla dubbel
                                    // Dealer has 3 cards and if we have a black jack, then we have already given
                                    if (!playerRightBlackJack) {
                                        coins += 2
                                    }
                                    showCoins()
                                } else {
           //                         addupdealer2.text = "Player wins"
                                    stack = stack + 100
             //                       stackOfCoins.text = stack.toString()
                                    // fast kolla dubbel

                                    if (!playerRightBlackJack) {
                                        coins += 4
                                    }
                                    //        coins += 4
                                    showCoins()
                                }
                            }
                        }

       //                 addPlayerCards2.text = addPlayerCards1.text

                        return
                    }
                }
// -------------------------------
                flip_dealercard5.setImageDrawable(getDrawable(randomCardsIntValue[0].name))

                if (true) {
                    sum =
                        dealerCards[0] + dealerCards[1] + dealerCards[2] + dealerCards[3] + dealerCards[4]

                  /*  if (sum > 21) {
                        if (dealerCards[0] == 11 || dealerCards[1] == 11 || dealerCards[2] == 11 || dealerCards[3] == 11 || dealerCards[4] == 11) {
                            sum =
                                dealerCards[0] + dealerCards[1] + dealerCards[2] + dealerCards[3] + dealerCards[4] - 10
                        }
                    }*/

                    var countAce = 0
                    for (i in 0..dealerCards.size - 1)
                    {
                        if (dealerCards[i] == 11)
                        {
                            countAce++
                        }
                    }
                  /*  if (countAce > 1)
                    {
                        sum = sum - (countAce-1)* 10
                    }*/
                    if (countAce > 1){

                        sum = sum - (countAce-1)* 10
                        if(sum > 21){
                            sum = dealerCards[0] + dealerCards[1] + dealerCards[2] + dealerCards[3] + dealerCards[4]
                            sum = sum - countAce*10
                        }
                    }
                    if (countAce == 1){
                        if(sum > 21){
                            sum = dealerCards[0] + dealerCards[1] + dealerCards[2] + dealerCards[3] + dealerCards[4]
                            sum = sum - countAce*10
                        }
                    }

                    addupdealer1.text = (sum).toString()

      //              addupdealer2.text = ""


                    if (sum > 21) {
                        addupdealer1.setBackgroundColor(Color.RED)
          //              addupdealer2.text = "Dealer to high"

         //               addupdealer2.text = "Player wins"
                        stack = stack + 100
         //               stackOfCoins.text = stack.toString()
                        dealerNoMoreCards = 5
                        // fast kolla dubbel
                        if (!playerLeftToMuch) {
                            if (!playerLeftBlackJack) {
                                //  coins += 4
                                if (DoubleActive) {
                                    coins += 8
                                } else {
                                    coins += 4
                                }
                            }
                        }
                //        coins += 4

                        // check if bust
                        if (weAreInSplit)
                        {
                         //   coins += 4
                            if (!playerRightToMuch) {
                                if (!playerRightBlackJack) {
                                    coins += 4
                                }
                            }
                        }

                        showCoins()

                        return
                    } else {
                        if (sum >= 17) {
                            //     Toast.makeText(this, "Dealer has to stand", Toast.LENGTH_LONG).show()
         //                   addupdealer2.text = "Dealer has to stand"
                            dealerNoMoreCards = 5

                 /*           var sumdealer =
                                dealerCards[0] + dealerCards[1] + dealerCards[2] + dealerCards[3] + dealerCards[4]*/

                            /*     var sumplayer = 0
                        for (i in 0..flipCardNumber+2) {
                            sumplayer += playerCards[i]
                        }*/

                            // five cards and not over 21 is black jack
                            var sumdealer = 21
                            addupdealer1.text = sumdealer.toString()

                            showDealPlaySum(sumdealer, sumplayer)
                            // vet ej
                          //  if ((sum > sumplayer) || (sumplayer > 21)){
                            if ((sumdealer > sumplayer) || playerLeftToMuch) {
      //                          addupdealer2.text = "Dealer wins"
                                stack = stack - 100
       //                         stackOfCoins.text = stack.toString()

                                //     showCoinsX_right()
                                showCoinsX2()
                            } else {
                                if (sumdealer == sumplayer) {
        //                            addupdealer2.text = "Split Pot"  // put money back
                                    // fast kolla dubbel
                              //      coins += 2
                                    // Dealer has 3 cards and if we have a black jack, then we have already given
                                    if (!playerLeftBlackJack) {
                                        if (DoubleActive) {
                                            coins += 4
                                        } else {
                                            coins += 2
                                        }
                                    }
                                    showCoins()
                                } else {
             //                       addupdealer2.text = "Player wins"
                                    stack = stack + 100
             //                       stackOfCoins.text = stack.toString()
                                    // fast kolla dubbel
                                    if (!playerLeftBlackJack) {
                                      //  coins += 4
                                        if (DoubleActive)
                                        {
                                            coins += 8
                                        }else
                                        {
                                            coins += 4
                                        }
                                    }
                       //             coins += 4
                                    showCoins()
                                }
                            }
                            if (weAreInSplit) {
                                // vet ej
                                if ((sumdealer > sumplayer_split) || playerRightToMuch){
         //                           addupdealer2.text = "Dealer wins"
                                    stack = stack - 100
         //                           stackOfCoins.text = stack.toString()

                      // already shown                   showCoinsX_right()
                            //        showCoinsX()
                                  //  if (!playerRightToMuch) {
                                        showCoinsX_right()
                                   // }
                                } else {
                                    if (sumdealer == sumplayer_split) {
             //                           addupdealer2.text = "Split Pot"  // put money back
                                        // fast kolla dubbel
                                        // Dealer has 3 cards and if we have a black jack, then we have already given
                                        if (!playerRightBlackJack) {
                                            coins += 2
                                        }
                                        showCoins()
                                    } else {
             //                           addupdealer2.text = "Player wins"
                                        stack = stack + 100
         //                               stackOfCoins.text = stack.toString()
                                        // fast kolla dubbel

                                        if (!playerRightBlackJack) {
                                            coins += 4
                                        }
                                 //       coins += 4
                                        showCoins()
                                    }
                                }
                            }

        //                    addPlayerCards2.text = addPlayerCards1.text

                            return
                        }
                    }

                }

       /*         if (weAreInSplit) {
                    sum =
                        dealerCards[0] + dealerCards[1] + dealerCards[2] + dealerCards[3] + dealerCards[4]

                    if (sum > 21) {
                        if (dealerCards[0] == 11 || dealerCards[1] == 11 || dealerCards[2] == 11 || dealerCards[3] == 11 || dealerCards[4] == 11) {
                            sum =
                                dealerCards[0] + dealerCards[1] + dealerCards[2] + dealerCards[3] + dealerCards[4] - 10
                        }
                    }

                    addupdealer1.text = (sum).toString()

                    addupdealer2.text = ""


                    if (sum > 21) {
                        addupdealer1.setBackgroundColor(Color.RED)
                        addupdealer2.text = "Dealer to high"

                        addupdealer2.text = "Player wins"
                        stack = stack + 100
                        stackOfCoins.text = stack.toString()
                        dealerNoMoreCards = 5

                        return
                    } else {
                        if (sum >= 17) {
                            //     Toast.makeText(this, "Dealer has to stand", Toast.LENGTH_LONG).show()
                            addupdealer2.text = "Dealer has to stand"
                            dealerNoMoreCards = 5

                            var sumdealer =
                                dealerCards[0] + dealerCards[1] + dealerCards[2] + dealerCards[3] + dealerCards[4]

                            /*     var sumplayer = 0
                        for (i in 0..flipCardNumber+2) {
                            sumplayer += playerCards[i]
                        }*/

                            // five cards and not over 21 is black jack
                            sumdealer = 21

                            showDealPlaySum(sumdealer, sumplayer)

                            if (sumdealer > sumplayer) {
                                addupdealer2.text = "Dealer wins"
                                stack = stack - 100
                                stackOfCoins.text = stack.toString()

                                //     showCoinsX_right()
                                showCoinsX()
                            } else {
                                if (sumdealer == sumplayer) {
                                    addupdealer2.text = "Split Pot"  // put money back
                                } else {
                                    addupdealer2.text = "Player wins"
                                    stack = stack + 100
                                    stackOfCoins.text = stack.toString()
                                }
                            }

                            addPlayerCards2.text = addPlayerCards1.text

                            return
                        }
                    }

                }*/

               // dealer has five cards and did not reach over 16, this is black jack
  // oddå              if (addupdealer2.text == ""){

        //        jaG TROR att vi aldrig når hit
                    var sumdealer2 = 21
                    addupdealer1.text = sumdealer2.toString()

                    showDealPlaySum(sumdealer2, sumplayer)

               //     if (sumdealer2 > sumplayer) {
                if ((sumdealer2 > sumplayer) || (sumplayer > 21)){
      //                  addupdealer2.text = "Dealer wins"
                        stack = stack - 100
      //                  stackOfCoins.text = stack.toString()

                        //     showCoinsX_right()
                        showCoinsX2()
                    } else {
                        if (sumdealer2 == sumplayer) {
        //                    addupdealer2.text = "Split Pot" // put money back
                            // fast kolla dubbel
                           // coins += 2
                            // Dealer has 3 cards and if we have a black jack, then we have already given
                            if (!playerLeftBlackJack) {
                                if (DoubleActive) {
                                    coins += 4
                                } else {
                                    coins += 2
                                }
                            }
                            showCoins()
                        } else {
         //                   addupdealer2.text = "Player wins"
                            stack = stack + 100
         //                   stackOfCoins.text = stack.toString()
                            // fast kolla dubbel
                            if (!playerLeftBlackJack) {
                               // coins += 4
                                if (DoubleActive)
                                {
                                    coins += 8
                                }else
                                {
                                    coins += 4
                                }
                            }
          //                  coins += 4
                            showCoins()
                        }
                    }
                    if (weAreInSplit) {
                //        if (sumdealer2 > sumplayer_split) {
                        if ((sumdealer2 > sumplayer_split) || (sumplayer_split > 21)){
      //                      addupdealer2.text = "Dealer wins"
                            stack = stack - 100
      //                      stackOfCoins.text = stack.toString()

              // already shown                   showCoinsX_right()
                        //    showCoinsX()
                            if (!playerRightToMuch) {
                                showCoinsX_right()
                            }
                        } else {
                            if (sumdealer2 == sumplayer_split) {
          //                      addupdealer2.text = "Split Pot" // put money back
                                // fast kolla dubbel
                                // Dealer has 3 cards and if we have a black jack, then we have already given
                                if (!playerRightBlackJack) {
                                    coins += 2
                                }
                                showCoins()
                            } else {
         //                       addupdealer2.text = "Player wins"
                                stack = stack + 100
          //                      stackOfCoins.text = stack.toString()
                                // fast kolla dubbel

                                if (!playerRightBlackJack) {
                                    coins += 4
                                }
            //                    coins += 4
                                showCoins()
                            }
                        }
                    }

     //               addPlayerCards2.text = addPlayerCards1.text
            //    }
            }
        }.start()

    }

    fun showDealPlaySum(dealerSum : Int, playerSum : Int){
   /*     var showdeal = findViewById<TextView>(R.id.showdeal)
        showdeal.text = dealerSum.toString()
        var showplay = findViewById<TextView>(R.id.showplay)
        showplay.text = playerSum.toString()*/
    }

    fun showToast() {
     //   Toast.makeText(this, "Inte siffra", Toast.LENGTH_LONG).show()
    }

    fun showSnackbar() {
      /*  val snack = Snackbar.make(it, "Inte en siffra", Snackbar.LENGTH_INDEFINITE)
                  snack.setAction("Jepp")
                  {

              }
           snack.show()*/
    }

    fun shuffleAgain() {
   /*     val snack = Snackbar.make(this, "Inte en siffra", Snackbar.LENGTH_INDEFINITE)
        snack.setAction("Jepp")
        {

        }
        snack.show()*/
    }

    /*
    private fun countdown2_not_use() {
        var flip_dealercard2 = findViewById<ImageView>(R.id.dealercard2)
        var flip_dealercard3 = findViewById<ImageView>(R.id.dealercard3)
        var flip_dealercard4 = findViewById<ImageView>(R.id.dealercard4)
        var flip_dealercard5 = findViewById<ImageView>(R.id.dealercard5)
        var addupdealer1 = findViewById<TextView>(R.id.addUpDealer1)


        var addupdealer2 = findViewById<TextView>(R.id.addUpDealer2)


        var addPlayerCards1 = findViewById<TextView>(R.id.addUpPlayerHigh)
        var addPlayerCards2 = findViewById<TextView>(R.id.addUpPlayer2High)
        var stackOfCoins = findViewById<TextView>(R.id.stack)




        addupdealer2.text = "start"

        object : CountDownTimer(1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                //             addupdealer2.text = (millisUntilFinished / 1000).toString()
                //  otp_resend.text = (millisUntilFinished / 1000).toString()
            }

            override fun onFinish() {
                // do something after countdown is done ie. enable button, change color
                //      etc.
                //     otp_resend.text = "done!"
                //          addupdealer2.text = "2 sekunder har gått"
                //            testar()
                randomCardsIntValue = cardArray.getOneRandomCardsValue()
                dealerCards.add(randomCardsIntValue[0].value)
                var sum = dealerCards[0] + dealerCards[1]
                addupdealer1.text = (sum).toString()

                addupdealer2.text = ""

                flip_dealercard2.setImageDrawable(getDrawable(randomCardsIntValue[0].name))
                if (sum > 21) {
                    addupdealer1.setBackgroundColor(Color.RED)
                    dealerNoMoreCards = 2
                    addupdealer2.text = "Player wins"
                    stack = stack + 100
                    stackOfCoins.text = stack.toString()

                } else {
                    if (sum >= 17) {
                        //   Toast.makeText(this, "Dealer has to stand", Toast.LENGTH_LONG).show()
                        /*     val snack = Snackbar.make(it, "Inte en siffra", Snackbar.LENGTH_INDEFINITE)
                                   snack.setAction("Jepp") {

                               }
                                   snack.show()*/
                        addupdealer2.text = "Dealer has to stand"
                        dealerNoMoreCards = 2
                        var sumdealer = dealerCards[0] + dealerCards[1]

                        // var sumplayer = 0
                        //var sumplayer = addPlayerCards.text

                        // måste summera äss här
                        /*  for (i in 0..flipCardNumber+2) {
                            sumplayer += playerCards[i]
                        }*/

                        showDealPlaySum(sumdealer, sumplayer)

                        if (sumdealer > sumplayer) {
                            addupdealer2.text = "Dealer wins"
                            stack = stack - 100
                            stackOfCoins.text = stack.toString()
                        } else {
                            if (sumdealer == sumplayer) {
                                addupdealer2.text = "Split Pot"
                            } else {
                                addupdealer2.text = "Player wins"
                                stack = stack + 100
                                stackOfCoins.text = stack.toString()
                            }
                        }
                        return
                    }
                }
                //if (addupdealer2.text == ""){
                //                secondcard = true
                // }

            }
        }.start()
        //  if (secondcard) {
        object : CountDownTimer(2000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                //        addupdealer2.text = (millisUntilFinished / 1000).toString()
                //  otp_resend.text = (millisUntilFinished / 1000).toString()
            }

            override fun onFinish() {
                // do something after countdown is done ie. enable button, change color
                //      etc.
                //     otp_resend.text = "done!"
                //         addupdealer2.text = "4 sekunder har gått"
                //            testar()
                if (dealerNoMoreCards != 0) {
                    return
                }
                randomCardsIntValue = cardArray.getOneRandomCardsValue()
                dealerCards.add(randomCardsIntValue[0].value)
                var sum = dealerCards[0] + dealerCards[1] + dealerCards[2]

                if (sum > 21) {
                    if (dealerCards[0] == 11 || dealerCards[1] == 11 || dealerCards[2] == 11) {
                        sum = dealerCards[0] + dealerCards[1] + dealerCards[2] - 10
                    }
                }

                addupdealer1.text = (sum).toString()

                flip_dealercard3.setImageDrawable(getDrawable(randomCardsIntValue[0].name))
                if (sum > 21) {
                    addupdealer1.setBackgroundColor(Color.RED)
                    addupdealer2.text = "Dealer to high"

                    addupdealer2.text = "Player wins"
                    stack = stack + 100
                    stackOfCoins.text = stack.toString()
                    dealerNoMoreCards = 3

                    return
                } else {
                    if (sum >= 17) {
                        dealerNoMoreCards = 3
                        //  Toast.makeText(this, "Dealer has to stand", Toast.LENGTH_LONG).show()
                        addupdealer2.text = "Dealer has to stand"

                        var sumdealer = dealerCards[0] + dealerCards[1] + dealerCards[2]

                        /* var sumplayer = 0

                        for (i in 0..flipCardNumber+2) {
                            sumplayer += playerCards[i]
                        }*/

                        showDealPlaySum(sumdealer, sumplayer)

                        if (sumdealer > sumplayer) {
                            addupdealer2.text = "Dealer wins"
                            stack = stack - 100
                            stackOfCoins.text = stack.toString()
                        } else {
                            if (sumdealer == sumplayer) {
                                addupdealer2.text = "Split Pot"
                            } else {
                                addupdealer2.text = "Player wins"
                                stack = stack + 100
                                stackOfCoins.text = stack.toString()
                            }
                        }

                        addPlayerCards2.text = addPlayerCards1.text

                        return
                    }
                }


            }
        }.start()

        object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                //         addupdealer2.text = (millisUntilFinished / 1000).toString()
                //  otp_resend.text = (millisUntilFinished / 1000).toString()
            }

            override fun onFinish() {
                // do something after countdown is done ie. enable button, change color
                //      etc.
                //     otp_resend.text = "done!"
                if (dealerNoMoreCards != 0) {
                    return
                }
                //        addupdealer2.text = "6 sekunder har gått"
                //            testar()
                randomCardsIntValue = cardArray.getOneRandomCardsValue()
                dealerCards.add(randomCardsIntValue[0].value)
                var sum = dealerCards[0] + dealerCards[1] + dealerCards[2]

                if (sum > 21) {
                    if (dealerCards[0] == 11 || dealerCards[1] == 11 || dealerCards[2] == 11) {
                        sum = dealerCards[0] + dealerCards[1] + dealerCards[2] - 10
                    }
                }

// Vi behöver nog inte ha detta
                if (sum > 21) {
                    addupdealer1.setBackgroundColor(Color.RED)
                    addupdealer2.text = "Dealer to high"

                    addupdealer2.text = "Player wins"
                    stack = stack + 100
                    stackOfCoins.text = stack.toString()
                    dealerNoMoreCards = 3

                    return
                } else {
                    if (sum >= 17) {
                        //      Toast.makeText(this, "Dealer has to stand", Toast.LENGTH_LONG).show()
                        addupdealer2.text = "Dealer has to stand"
                        dealerNoMoreCards = 3
                        var sumdealer = dealerCards[0] + dealerCards[1] + dealerCards[2]

                        showDealPlaySum(sumdealer, sumplayer)

                        if (sumdealer > sumplayer) {
                            addupdealer2.text = "Dealer wins"
                            stack = stack - 100
                            stackOfCoins.text = stack.toString()
                        } else {
                            if (sumdealer == sumplayer) {
                                addupdealer2.text = "Split Pot"
                            } else {
                                addupdealer2.text = "Player wins"
                                stack = stack + 100
                                stackOfCoins.text = stack.toString()
                            }
                        }

                        addPlayerCards2.text = addPlayerCards1.text

                        return
                    }
                }

                sum = dealerCards[0] + dealerCards[1] + dealerCards[2] + dealerCards[3]

                if (sum > 21) {
                    if (dealerCards[0] == 11 || dealerCards[1] == 11 || dealerCards[2] == 11 || dealerCards[3] == 11) {
                        sum =
                            dealerCards[0] + dealerCards[1] + dealerCards[2] + dealerCards[3] - 10
                    }
                }

                addupdealer1.text = (sum).toString()

                flip_dealercard4.setImageDrawable(getDrawable(randomCardsIntValue[0].name))

                if (sum > 21) {
                    addupdealer1.setBackgroundColor(Color.RED)
                    addupdealer2.text = "Dealer to high"

                    addupdealer2.text = "Player wins"
                    stack = stack + 100
                    stackOfCoins.text = stack.toString()
                    dealerNoMoreCards = 4

                    return
                } else {
                    if (sum >= 17) {
                        //      Toast.makeText(this, "Dealer has to stand", Toast.LENGTH_LONG).show()
                        dealerNoMoreCards = 4
                        addupdealer2.text = "Dealer has to stand"
                        var sumdealer =
                            dealerCards[0] + dealerCards[1] + dealerCards[2] + dealerCards[3]


                        showDealPlaySum(sumdealer, sumplayer)

                        if (sumdealer > sumplayer) {
                            addupdealer2.text = "Dealer wins"
                            stack = stack - 100
                            stackOfCoins.text = stack.toString()
                        } else {
                            if (sumdealer == sumplayer) {
                                addupdealer2.text = "Split Pot"
                            } else {
                                addupdealer2.text = "Player wins"
                                stack = stack + 100
                                stackOfCoins.text = stack.toString()
                            }
                        }

                        addPlayerCards2.text = addPlayerCards1.text

                        return
                    }
                }


            }
        }.start()

        object : CountDownTimer(4000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {

                if (dealerNoMoreCards != 0) {
                    return
                }

                randomCardsIntValue = cardArray.getOneRandomCardsValue()
                dealerCards.add(randomCardsIntValue[0].value)

                var sum = dealerCards[0] + dealerCards[1] + dealerCards[2] + dealerCards[3]

                if (sum > 21) {
                    if (dealerCards[0] == 11 || dealerCards[1] == 11 || dealerCards[2] == 11 || dealerCards[3] == 11) {
                        sum =
                            dealerCards[0] + dealerCards[1] + dealerCards[2] + dealerCards[3] - 10
                    }
                }

                if (sum > 21) {
                    addupdealer1.setBackgroundColor(Color.RED)
                    addupdealer2.text = "Dealer to high"

                    addupdealer2.text = "Player wins"
                    stack = stack + 100
                    stackOfCoins.text = stack.toString()
                    dealerNoMoreCards = 4

                    return
                } else {
                    if (sum >= 17) {
                        //      Toast.makeText(this, "Dealer has to stand", Toast.LENGTH_LONG).show()
                        addupdealer2.text = "Dealer has to stand"
                        dealerNoMoreCards = 4

                        var sumdealer =
                            dealerCards[0] + dealerCards[1] + dealerCards[2] + dealerCards[3]


                        showDealPlaySum(sumdealer, sumplayer)

                        if (sumdealer > sumplayer) {
                            addupdealer2.text = "Dealer wins"
                            stack = stack - 100
                            stackOfCoins.text = stack.toString()
                        } else {
                            if (sumdealer == sumplayer) {
                                addupdealer2.text = "Split Pot"
                            } else {
                                addupdealer2.text = "Player wins"
                                stack = stack + 100
                                stackOfCoins.text = stack.toString()
                            }
                        }

                        addPlayerCards2.text = addPlayerCards1.text

                        return
                    }
                }


                sum =
                    dealerCards[0] + dealerCards[1] + dealerCards[2] + dealerCards[3] + dealerCards[4]

                if (sum > 21) {
                    if (dealerCards[0] == 11 || dealerCards[1] == 11 || dealerCards[2] == 11 || dealerCards[3] == 11 || dealerCards[4] == 11) {
                        sum =
                            dealerCards[0] + dealerCards[1] + dealerCards[2] + dealerCards[3] + dealerCards[4] - 10
                    }
                }

                addupdealer1.text = (sum).toString()

                flip_dealercard5.setImageDrawable(getDrawable(randomCardsIntValue[0].name))
                if (sum > 21) {
                    addupdealer1.setBackgroundColor(Color.RED)
                    addupdealer2.text = "Dealer to high"

                    addupdealer2.text = "Player wins"
                    stack = stack + 100
                    stackOfCoins.text = stack.toString()
                    dealerNoMoreCards = 5

                    return
                } else {
                    if (sum >= 17) {
                        //     Toast.makeText(this, "Dealer has to stand", Toast.LENGTH_LONG).show()
                        addupdealer2.text = "Dealer has to stand"
                        dealerNoMoreCards = 5

                        var sumdealer =
                            dealerCards[0] + dealerCards[1] + dealerCards[2] + dealerCards[3] + dealerCards[4]

                        showDealPlaySum(sumdealer, sumplayer)

                        if (sumdealer > sumplayer) {
                            addupdealer2.text = "Dealer wins"
                            stack = stack - 100
                            stackOfCoins.text = stack.toString()
                        } else {
                            if (sumdealer == sumplayer) {
                                addupdealer2.text = "Split Pot"
                            } else {
                                addupdealer2.text = "Player wins"
                                stack = stack + 100
                                stackOfCoins.text = stack.toString()
                            }
                        }

                        addPlayerCards2.text = addPlayerCards1.text

                        return
                    }
                }


            }
        }.start()


    }*/

    fun check(buttonpressed : String) {

        returnStringGlobal = ""
 //       checkAccordingToStrategy(playerCards[0], playerCards[1], dealerCards[0], 0)

        var sum = 0
        var countAce = 0




        if ((buttonpressed == "CARDSLEFT") || (buttonpressed == "STANDLEFT"))
        {
            if (playerCards.size > 2) {

                for (i in 0..playerCards.size - 1) {
                    sum += playerCards[i]
                    if (playerCards[i] == 11) {
                        countAce++
                    }

                    if ((sum > 21) && (countAce == 1)) {
                        sum -= 10
                    }

                    if ((sum > 21) && (countAce == 2)) {
                        sum -= 10
                    }

                    if ((sum > 21) && (countAce == 3)) {
                        sum -= 10
                    }

                    if ((sum > 21) && (countAce == 4)) {
                        sum -= 10
                    }

                    if ((sum > 21) && (countAce == 5)) {
                        sum -= 10
                    }
                }
                checkAccordingToStrategy(
                    playerCards[0],
                    playerCards[1],
                    dealerCards[0],
                    sum
                )

            } else {
                checkAccordingToStrategy(
                    playerCards[0],
                    playerCards[1],
                    dealerCards[0],
                    0
                )

                sum = playerCards[0] + playerCards[1]
                // two aces
                if (sum > 21) {
                    sum -= 10
                }
            }
        }

        if ((buttonpressed == "CARDSRIGHT") || (buttonpressed == "STANDRIGHT"))
        {
            if (playerCards_split.size > 2) {

                for (i in 0..playerCards_split.size - 1) {
                    sum += playerCards_split[i]
                    if (playerCards_split[i] == 11) {
                        countAce++
                    }

                    if ((sum > 21) && (countAce == 1)) {
                        sum -= 10
                    }

                    if ((sum > 21) && (countAce == 2)) {
                        sum -= 10
                    }

                    if ((sum > 21) && (countAce == 3)) {
                        sum -= 10
                    }

                    if ((sum > 21) && (countAce == 4)) {
                        sum -= 10
                    }

                    if ((sum > 21) && (countAce == 5)) {
                        sum -= 10
                    }
                }
                checkAccordingToStrategy(
                    playerCards_split[0],
                    playerCards_split[1],
                    dealerCards[0],
                    sum
                )
            } else {
                checkAccordingToStrategy(
                    playerCards_split[0],
                    playerCards_split[1],
                    dealerCards[0],
                    0
                )

  /*              sum = playerCards_split[0] + playerCards_split[1]

                if (sum > 21) {
                    sum -= 10
                }*/
            }
        }

        if (buttonpressed == "SPLIT")
        {
                checkAccordingToStrategy(
                    playerCards[0],
                    playerCards[1],
                    dealerCards[0],
                    0
                )

 /*               sum = playerCards[0] + playerCards[1]

                if (sum > 21) {
                    sum -= 10
                }*/
        }

        if (buttonpressed == "DOUBLE")
        {
            checkAccordingToStrategy(
                playerCards[0],
                playerCards[1],
                dealerCards[0],
                0
            )

            /*               sum = playerCards[0] + playerCards[1]

                           if (sum > 21) {
                               sum -= 10
                           }*/
        }


        var showBar = false

        if ((buttonpressed == "CARDSLEFT") && (returnStringGlobal != "H")){
            // OK, not perfect, when split, I do not check all
            if (!weAreInSplit) {
                showBar = true
            }
        }

        if ((buttonpressed == "STANDLEFT") && (returnStringGlobal != "S")){
            // OK, not perfect, when split, I do not check all
            if (!weAreInSplit) {
                showBar = true
            }
        }

        if ((buttonpressed == "CARDSRIGHT") && (returnStringGlobal != "H")){
            // OK, not perfect, when split, I do not check all
            if (!weAreInSplit) {
                showBar = true
            }
        }

        if ((buttonpressed == "STANDRIGHT") && (returnStringGlobal != "S")){
            // OK, not perfect, when split, I do not check all
            if (!weAreInSplit) {
                showBar = true
            }
        }

        if ((buttonpressed == "DOUBLE") && (returnStringGlobal != "DD")){
            showBar = true
        }

        if ((buttonpressed == "SPLIT") && (returnStringGlobal != "SP")){
            showBar = true
        }

        // Double only possible with 2 cards
  /*      if ((returnStringGlobal == "DD") && ((buttonpressed == "CARDSLEFT") || (buttonpressed == "STANDLEFT"))){
            if (playerCards.size > 2){
                showBar = false
            }
        }

        // Double only possible with 2 cards
        if ((returnStringGlobal == "DD") && ((buttonpressed == "CARDSRIGHT") || (buttonpressed == "STANDRIGHT"))){
            if (playerCards_split.size > 2){
                showBar = false
            }
        }*/

        // Check if table says Stand
        if (showBar) {
    // vi kan inte hoppa till något som inte är skapat ??                        strategy.startMoveArrow(playerCards[0], playerCards[1], playerCards[2], playerCards[3], playerCards[4], dealerCards[0])

            val snack =
                Snackbar.make(
                    findViewById(android.R.id.content),
                    "Inte enligt tabell, se tabell?",
                    Snackbar.LENGTH_LONG
                )
            snack.setAction("Jepp")
            {
                moveArrow()
            }
            snack.show()
        }
    }

    fun moveArrow(){
            val intent = Intent(this, ShowStrategyPic::class.java)
               intent.putExtra("playercard1", playerCards[0].toString())
               intent.putExtra("playercard2", playerCards[1].toString())
               if (playerCards.size > 2) {
                   intent.putExtra("playercard3", playerCards[2].toString())
               }
               if (playerCards.size > 3) {
                   intent.putExtra("playercard4", playerCards[3].toString())
               }
               if (playerCards.size > 4) {
                   intent.putExtra("playercard5", playerCards[4].toString())
               }
               intent.putExtra("dealercard1", dealerCards[0].toString())

               startActivity(intent)
        //                       strategy.startMoveArrow(playerCards[0], playerCards[1], playerCards[2], playerCards[3], playerCards[4], dealerCards[0])


    }

}

