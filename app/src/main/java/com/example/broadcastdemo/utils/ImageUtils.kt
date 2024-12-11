package com.example.broadcastdemo.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import java.io.File
import java.io.FileOutputStream

object ImageUtils {
    fun resizeAndSaveImage(context: Context, uri: Uri): File {
        val inputStream = context.contentResolver.openInputStream(uri)
        val bitmap = BitmapFactory.decodeStream(inputStream)
        
        // Calculate scaling factors to reach 800x600 while maintaining aspect ratio
        val targetWidth = 800f
        val targetHeight = 600f
        val widthRatio = targetWidth / bitmap.width
        val heightRatio = targetHeight / bitmap.height
        val scaleFactor = minOf(widthRatio, heightRatio)
        
        val scaledBitmap = Bitmap.createScaledBitmap(
            bitmap,
            (bitmap.width * scaleFactor).toInt(),
            (bitmap.height * scaleFactor).toInt(),
            true
        )

        // Create temporary file
        val file = File(context.cacheDir, "temp_image_${System.currentTimeMillis()}.jpg")
        FileOutputStream(file).use { out ->
            scaledBitmap.compress(Bitmap.CompressFormat.JPEG, 90, out)
        }

        return file
    }

    fun getImageUrl(imagePath: String): String {
        return "https://labs.anontech.info/cse489/t3/$imagePath"
    }
}
