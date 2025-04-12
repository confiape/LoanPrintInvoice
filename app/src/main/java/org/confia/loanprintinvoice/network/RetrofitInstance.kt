package org.confia.loanprintinvoice.network
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import okhttp3.OkHttpClient
import org.confia.loanprintinvoice.apis.PaymentApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type
import java.time.OffsetDateTime

object RetrofitInstance {

    private var authToken: String? = null

    fun setAuthToken(token: String?) {
        authToken = token
    }

    val api: PaymentApi by lazy {




        val gson = GsonBuilder()
            .registerTypeAdapter(OffsetDateTime::class.java, OffsetDateTimeAdapter())
            .create()

        Retrofit.Builder()
            .baseUrl("https://9265-102-129-152-99.ngrok-free.app/")
            .addConverterFactory(GsonConverterFactory.create(gson))

            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder().addInterceptor { chain ->
                    val requestBuilder = chain.request().newBuilder()
                    authToken?.let {
                        requestBuilder.addHeader("Authorization", "Bearer $it")
                    }
                    chain.proceed(requestBuilder.build())
                }.build()
            )
            .build()
            .create(PaymentApi::class.java)
    }

    class OffsetDateTimeAdapter : JsonDeserializer<OffsetDateTime>, JsonSerializer<OffsetDateTime> {
        override fun deserialize(
            json: JsonElement?,
            typeOfT: Type?,
            context: JsonDeserializationContext?
        ): OffsetDateTime {
            return OffsetDateTime.parse(json?.asString)
        }

        override fun serialize(
            src: OffsetDateTime?,
            typeOfSrc: Type?,
            context: JsonSerializationContext?
        ): JsonElement {
            return JsonPrimitive(src.toString())
        }

    }
}