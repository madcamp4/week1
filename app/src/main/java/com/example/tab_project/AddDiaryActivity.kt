package com.example.tab_project

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tab_project.databinding.ActivityAdddiaryBinding

class AddDiaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdddiaryBinding

    val diaryAdapter = DiaryAdapterSingleton.diaryAdapter // 글로벌 변수를 불러와서 사용

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAdddiaryBinding.inflate(layoutInflater) //activity.xml을 참조할 수 있도록 만든 binding class
        setContentView(binding.root)

        binding.btnCancelEntry.setOnClickListener {
            finish()
        }

        binding.btnSaveEntry.setOnClickListener {
            val date = binding.etDiaryDate.text.toString()
            val title = binding.etDiaryTitle.text.toString()
            val content = binding.etDiaryContent.text.toString()

//            val intent = Intent()
//
////            val new_diaryData = DiaryData(date, title, content, icon = 1)
////            intent.putExtra("diaryData", new_diaryData)
//
//            intent.apply {
//                putExtra("date", date)
//                putExtra("title", title)
//                putExtra("content", content)
//                putExtra("icon", 1)
//            }
//            setResult(Activity.RESULT_OK, intent)

            val newDiaryData = DiaryData(date, title, content, icon = null)

            diaryAdapter.DiaryList.add(newDiaryData)

            finish()

        }

    }
}