package com.example.image_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

//import jdk.internal.platform.Container.metrics



var rowGlobal = 0
var columnGlobal = 0


class ShowStrategyPic : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_strategy_pic)
    }


    override fun onStart() {

        super.onStart()

        var arrow = findViewById<ImageView>(R.id.stratarrow)
        arrow.visibility = View.INVISIBLE

  /*      findViewById<Button>(R.id.radkolumnBtn).setOnClickListener {
            movearrow(10, 1)
        }*/

        val playercard1 = intent.getStringExtra("playercard1")
        Log.i("size", "playercard1 " + playercard1)
        val playercard2 = intent.getStringExtra("playercard2")
        Log.i("size", "playercard2 " + playercard2)
        val playercard3 = intent.getStringExtra("playercard3")
        Log.i("size", "playercard3 " + playercard3)
        val playercard4 = intent.getStringExtra("playercard4")
        Log.i("size", "playercard4 " + playercard4)
        val playercard5 = intent.getStringExtra("playercard5")
        Log.i("size", "playercard5 " + playercard5)
        val dealercard1 = intent.getStringExtra("dealercard1")
        Log.i("size", "dealercard1 " + dealercard1)

        var playerCard1 : Int
        var playerCard2 : Int
        var playerCard3 : Int
        var playerCard4 : Int
        var playerCard5 : Int
        var dealerCard1 : Int

        if (playercard1 == null) {
            playerCard1 = 0
        }
        else
        {
            playerCard1 = playercard1.toInt()
        }
        if (playercard2 == null) {
            playerCard2 = 0
        }
        else
        {
            playerCard2 = playercard2.toInt()
        }
        if (playercard3 == null) {
            playerCard3 = 0
        }
        else
        {
            playerCard3 = playercard3.toInt()
        }
        if (playercard4 == null) {
            playerCard4 = 0
        }
        else
        {
            playerCard4 = playercard4.toInt()
        }
        if (playercard5 == null) {
            playerCard5 = 0
        }
        else
        {
            playerCard5 = playercard5.toInt()
        }
        if (dealercard1 == null) {
            dealerCard1 = 0
        }
        else
        {
            dealerCard1 = dealercard1.toInt()
        }

        if (playercard1 != null)
        {
            Log.i("size", "här2 " + playerCard1)
            Log.i("size", "här3 " + playerCard2)
            Log.i("size", "här4 " + playerCard3)
            Log.i("size", "här4 " + playerCard4)
            Log.i("size", "här5 " + playerCard5)
            Log.i("size", "härdeal " + dealerCard1)
  // tar bort tillfälligt ?          startMoveArrow(playerCard1.toInt(), playerCard2.toInt(), playerCard3.toInt(), playerCard4.toInt(), playerCard5.toInt(), dealerCard1.toInt())
        }
        else
        {
            Log.i("size", "här1111  " + playercard1)
        }

    }


    fun startMoveArrow(playerCard1 : Int, playerCard2: Int, playerCard3 : Int, playerCard4: Int, playerCard5: Int, dealerCard : Int)
    {
        var playerCard1_Here = playerCard1
        var playerCard2_Here = playerCard2
        var sum = playerCard1_Here + playerCard2_Here
        var row = 0
        var column = 0

    //    return
        // Makes it more easy below
        if (playerCard1_Here < playerCard2_Here)
        {
            var tempCard = playerCard1_Here
            playerCard1_Here = playerCard2_Here
            playerCard2_Here = tempCard
        }


        // This takes care of the pairs
        if (playerCard1_Here == playerCard2_Here)
        {
            when(playerCard1_Here)
            {
                2 -> {
                    row = 26
                }
                3 -> {
                    row = 25
                }
                4 -> {
                    row = 24
                }
                5 -> {
                    row = 23
                }
                6 -> {
                    row = 22
                }
                7 -> {
                    row = 21
                }
                8 -> {
                    row = 18
                }
                9 -> {
                    row = 20
                }
                10 -> {
                    row = 19
                }
                11 -> {
                    row = 18
                }
                else -> {

                }
            }
        }

        // if there was an ace 11, it is now playercard1
        if (playerCard1_Here == 11)
        {
            when(playerCard2_Here)
            {
                2 -> {
                    row = 17
                }
                3 -> {
                    row = 16
                }
                4 -> {
                    row = 15
                }
                5 -> {
                    row = 14
                }
                6 -> {
                    row = 13
                }
                7 -> {
                    row = 12
                }
                8 -> {
                    row = 11
                }
                9 -> {
                    row = 11
                }
                10 -> {
                    row = 11
                }

                else -> {

                }
            }

        }

        // could be a pair or ace but more cards
        if ((row == 0) || (playerCard3 != 0) || (playerCard4 != 0) || (playerCard5 != 0))
        {
            sum = playerCard1 + playerCard2 + playerCard3 + playerCard4 + playerCard5
            var countAce = 0
            // we have to check for more than one ace
            if (playerCard1 == 11)
            {
                countAce += 1
            }
            if (playerCard2 == 11){
                countAce += 1
            }
            if (playerCard3 == 11){
                countAce += 1
            }
            if (playerCard4 == 11){
                countAce += 1
            }
            if (playerCard5 == 11){
                countAce += 1
            }

            // only one ace counted as 11. but this is not correct. all aces can be counted as 1
            // TODO later
            if (countAce > 1)
            {
                sum = sum - (countAce - 1)*10
            }

            when (sum) {
                5 -> {
                    row = 10
                }
                6 -> {
                    row = 10
                }
                7 -> {
                    row = 10
                }
                8 -> {
                    row = 10
                }
                9 -> {
                    row = 9
                }
                10 -> {
                    row = 8
                }
                11 -> {
                    row = 7
                }
                12 -> {
                    row = 6
                }
                13 -> {
                    row = 5
                }
                14 -> {
                    row = 4
                }
                15 -> {
                    row = 3
                }
                16 -> {
                    row = 2
                }
                17 -> {
                    row = 1
                }
                18 -> {
                    row = 1
                }
                19 -> {
                    row = 1
                }
                20 -> {
                    row = 1
                }
                21 -> {
                    row = 1
                }
                else -> {
                }
            }
        }

        when(dealerCard)
        {
            11 -> {
                column = 10
            }
            else -> {
                column = dealerCard - 1
            }
        }
        Log.i("size", "move row" + row.toString())
        Log.i("size", "move column" + column.toString())
       movearrow(column, row)
    }

        fun movearrow(kolumnin : Int, radin : Int){

            var kolumninTemp = (kolumnin - 1)*10
            var radinTemp = (radin - 1)*10

            var kolumn = 0f
            var rad = 0f


            var arrow = findViewById<ImageView>(R.id.stratarrow)
            var stratimage = findViewById<ImageView>(R.id.strategyImage)

            var imgWidth = stratimage.layoutParams.width.toFloat()
            Log.i("size", "BILLTEST width: " + imgWidth.toString())
            var imgHeight = stratimage.layoutParams.height.toFloat()
            Log.i("size", "BILLTEST height: " + imgHeight.toString())

            var imgWidth_part = imgWidth / 130
            var imgHeight_part = imgHeight / 392

            Log.i("size", "imgWidth_part: " + imgWidth_part.toString())
            Log.i("size", "imgHeight_part: " + imgHeight_part.toString())

 //           findViewById<TextView>(R.id.widthTV).text = imgWidth.toString()
  //          findViewById<TextView>(R.id.heightTV).text = imgHeight.toString()

            var offsetX = imgWidth_part*27.0
            var offsetY = imgHeight_part*45.0

            kolumn = (offsetX + imgWidth_part*kolumninTemp).toFloat()
            rad = (offsetY + imgHeight_part*radinTemp).toFloat()

            arrow.animate().setDuration(50).translationX(kolumn)
            arrow.animate().setDuration(50).translationY(rad)
        }

    fun movearrow2(kolumnin : Float, radin : Float){
        var kolumn = 0f
        var rad = 0f

  //      var right_down_card = findViewById<ImageView>(R.id.stratarrow2)
        val scale: Float = resources.displayMetrics.density

        kolumn = 0 + 210*(kolumnin - 1)
        rad = 70 + 41*radin

        kolumn = kolumn / scale
        rad = rad / scale

        /*        if (takebackx != 0f) {
                    right_down_card.animate().setDuration(50).translationXBy(-takebackx)
                    right_down_card.animate().setDuration(50).translationYBy(-takebacky)
                }
                takebackx = kolumn
                takebacky = rad*/

    //    right_down_card.animate().setDuration(50).translationX(kolumn)
    //    right_down_card.animate().setDuration(50).translationY(rad)
    }

    fun movearrow3(kolumnin : Float, radin : Float){
        var kolumn = 0f
        var rad = 0f

   //     var right_down_card = findViewById<ImageView>(R.id.stratarrow3)
        val scale: Float = resources.displayMetrics.density

        kolumn = 0 + 78*(kolumnin - 3)
        rad = 70 + 112*radin

        kolumn = kolumn / scale
        rad = rad / scale

        /*        if (takebackx != 0f) {
                    right_down_card.animate().setDuration(50).translationXBy(-takebackx)
                    right_down_card.animate().setDuration(50).translationYBy(-takebacky)
                }
                takebackx = kolumn
                takebacky = rad*/

   //     right_down_card.animate().setDuration(50).translationX(kolumn)
    //    right_down_card.animate().setDuration(50).translationY(rad)
    }

    fun movearrow4(kolumnin : Float, radin : Float){
        var kolumn = 0f
        var rad = 0f

  //      var right_down_card = findViewById<ImageView>(R.id.stratarrow4)
        val scale: Float = resources.displayMetrics.density

        kolumn = 0 + 210*(kolumnin - 3)
        rad = 70 + 112*radin

        kolumn = kolumn / scale
        rad = rad / scale


  //      right_down_card.animate().setDuration(50).translationX(kolumn)
  //      right_down_card.animate().setDuration(50).translationY(rad)
    }

}