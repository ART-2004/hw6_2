package com.example.hw6_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.hw6_2.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditBinding
    private var imageURL = arrayListOf<ImageModel>()
    private var selectedImage = arrayListOf<ImageModel>()
    private lateinit var imageAdapter: ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fillList()
        initViews()
        clickSend()
    }

    private fun clickSend() {
        binding.btnSend.setOnClickListener {
            if (selectedImage.isNotEmpty()){
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra(AppConstant.SELECTED_LIST, selectedImage)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please choose any photo!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun fillList() {
        imageURL.add(ImageModel("https://animania-shop.ru/assets/cache/images/!blog/oblozhki/main-qimg-f693b62575b6609c1c863424122e5ff9-600x-1c0.png"))
        imageURL.add(ImageModel("https://w7.pngwing.com/pngs/514/833/png-transparent-haruka-nanase-anime-art-blue-spring-ride-anime-caracter-black-hair-manga-fictional-character.png"))
        imageURL.add(ImageModel("https://w7.pngwing.com/pngs/696/226/png-transparent-anime-character-mangaka-hunter-%C3%97-hunter-game-street-promotion.png"))
        imageURL.add(ImageModel("https://media.2x2tv.ru/content/images/2022/04/1611233625_1.jpg"))
        imageURL.add(ImageModel("https://media.2x2tv.ru/content/images/2022/04/1611233625_1.jpg"))
        imageURL.add(ImageModel("https://aniyuki.com/wp-content/uploads/2022/06/the-cutest-anime-characters-demon-slayer-7.jpg"))
        imageURL.add(ImageModel("https://free-png.ru/wp-content/uploads/2022/07/free-png.ru-717-313x340.png"))
        imageURL.add(ImageModel("https://nntheblog.com/wp-content/uploads/2021/09/shoto-todoroki.jpg"))
        imageURL.add(ImageModel("https://cs11.pikabu.ru/post_img/big/2020/08/26/6/1598432456249557793.png"))
        imageURL.add(ImageModel("https://pm1.narvii.com/7624/9bacb073a59db4231477e93fb284f32e35235952r1-306-306v2_hq.jpg"))
        imageURL.add(ImageModel("https://nntheblog.com/wp-content/uploads/2021/11/Ken-Kaneki.jpg"))
        imageURL.add(ImageModel("https://sun9-73.userapi.com/impg/I3HkThGL02BOiYhWrEvO_qvI2cCbrp4GoTeSng/M2zmh5Ywpio.jpg?size=1024x576&quality=96&sign=a66f8bed56803629cb3a8b3f7cee0aa6&type=album"))
        imageURL.add(ImageModel("https://animania-shop.ru/assets/cache/images/!blog/oblozhki/4b1ebcf0c79534f430dc7d7ebbc71e5b-600x-0ab.jpg"))
        imageURL.add(ImageModel("https://ururuanime.online/uploads/qt8xg_8349f28751.jpg"))
        imageURL.add(ImageModel("https://you-anime.ru/anime-images/characters/character_50902.jpg?1679042907"))
    }

    private fun initViews() {
        imageAdapter = ImageAdapter(imageURL, this::onClickListener, this::deleteItem)
        binding.rvEdit.layoutManager = GridLayoutManager(this, 3)
        binding.rvEdit.adapter = imageAdapter
    }

    private fun onClickListener(item: ImageModel) {
        selectedImage.add(item)
    }

    private fun deleteItem(item: ImageModel) {
        selectedImage.remove(item)
    }

    object AppConstant{
        const val SELECTED_LIST = "selectedList"
    }
}