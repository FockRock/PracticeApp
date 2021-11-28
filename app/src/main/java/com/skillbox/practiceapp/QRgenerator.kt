package com.skillbox.practiceapp

import android.content.Intent
import android.os.Bundle
//import androidmads.library.qrgenearator.QRGContents
//import androidmads.library.qrgenearator.QRGEncoder
import androidx.appcompat.app.AppCompatActivity
//import com.google.zxing.WriterException
import com.skillbox.practiceapp.databinding.QrGeneratorBinding

class QRgenerator: AppCompatActivity() {

    lateinit var binding: QrGeneratorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = QrGeneratorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bQRscan.setOnClickListener {
            startActivity(Intent(this, QRScanner::class.java))
        }

//        binding.bGenerate.setOnClickListener {
//            qr(binding.editTextTextPersonName.text.toString())
//        }
    }
//
//    private fun qr(text: String) {
//        val qrGenerator = QRGEncoder(text, null, QRGContents.Type.TEXT,400)
//        try {
//            val bMap = qrGenerator.encodeAsBitmap()
//            binding.imageView.setImageBitmap(bMap)
//
//        } catch (e: WriterException) {
//
//        }
//    }
}