package com.necipallef.wordstudy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var mWordList: ArrayList<String>
    private var currentCount = 0
    private var totalCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mWordList = Words.englishChapter1
        totalCount = mWordList.size

        nextButton.setOnClickListener { switchToNextWord() }
    }


    private fun switchToNextWord() {
        if (mWordList.isEmpty())
            return

        val randomIndex = Random().nextInt(mWordList.size)
        val nextWord = mWordList[randomIndex]
        mWordList.removeAt(randomIndex)
        wordTV.text = nextWord

        currentCount++
        countTV.text = "$currentCount/$totalCount"
    }
}
