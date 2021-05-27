package com.example.bookapplication.model

import com.google.gson.annotations.SerializedName

data class items(@SerializedName("volumeInfo")val volumeInfo:VolumeInfo)
