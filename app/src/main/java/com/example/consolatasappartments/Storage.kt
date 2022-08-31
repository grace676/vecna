package com.example.consolatasappartments

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.IOException
import java.util.*

class Storage : AppCompatActivity() {
    private val PICK_IMAGE_REQUEST = 71
    private var filePath: Uri? = null
    private var firebaseStore: FirebaseStorage? = null
    private var storageReference: StorageReference? = null
    lateinit var imagePreview: ImageView
    lateinit var btn_choose_image: Button
    lateinit var btn_upload_image: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storage)
        btn_choose_image = findViewById(R.id.btn_choose_image)
        btn_upload_image = findViewById(R.id.btn_upload_image)
        imagePreview = findViewById(R.id.image_preview)

        firebaseStore = FirebaseStorage.getInstance()
        storageReference = FirebaseStorage.getInstance().reference



        btn_choose_image.setOnClickListener {
            launchGallery() }
        btn_upload_image.setOnClickListener {
            uploadImage() }
    }



    private fun launchGallery() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
            if(data == null || data.data == null){
                return
            }

            filePath = data.data
            try {
                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, filePath)
                imagePreview.setImageBitmap(bitmap)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    private fun uploadImage() : Any = if(filePath != null){
        val ref = storageReference?.child("myImages/" + UUID.randomUUID().toString())
        val uploadTask = ref?.putFile(filePath!!)

    }else{
        Toast.makeText(this, "Please Upload an Image", Toast.LENGTH_SHORT).show()}



}






