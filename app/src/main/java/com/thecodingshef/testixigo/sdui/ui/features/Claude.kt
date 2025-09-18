//package com.thecodingshef.testixigo.sdui.ui.features
//
//import android.content.Context
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.lazy.grid.GridCells
//import androidx.compose.foundation.lazy.grid.GridItemSpan
//import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
//import androidx.compose.foundation.lazy.grid.items
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Error
//import androidx.compose.material3.Button
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.CircularProgressIndicator
//import androidx.compose.material3.Icon
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.viewinterop.AndroidView
//import androidx.hilt.navigation.compose.hiltViewModel
//import androidx.lifecycle.LifecycleOwner
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import coil3.compose.AsyncImage
//import coil3.request.Disposable
//import com.thecodingshef.testixigo.sdui.data.api.SDUIApiService
//import com.yandex.div.core.Div2Context
//import com.yandex.div.core.DivConfiguration
//import com.yandex.div.core.images.DivImageLoader
//import com.yandex.div.core.view2.Div2View
//import com.yandex.div2.DivData
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.lifecycle.HiltViewModel
//import dagger.hilt.android.qualifiers.ApplicationContext
//import dagger.hilt.components.SingletonComponent
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.flow.asStateFlow
//import kotlinx.coroutines.launch
//import org.chromium.base.Callback
//import retrofit2.Response
//import retrofit2.http.GET
//import javax.inject.Inject
//import javax.inject.Singleton
//
//
//// Data Models
//data class FlightDestination(
//    val id: String,
//    val name: String,
//    val date: String,
//    val price: String,
//    val imageUrl: String,
//    val currency: String = "₹"
//)
//
//data class FlightResponse(
//    val title: String,
//    val fromCity: String,
//    val destinations: List<FlightDestination>
//)
//
//data class DivKitResponse(
//    val card: DivData
//)
//
//// API Interface
//// Repository
//interface FlightRepository {
//    suspend fun getCheapestFlights(): Result<DivKitResponse>
//    suspend fun getMockFlightData(): Result<FlightResponse>
//}
//
//@Singleton
//class FlightRepositoryImpl @Inject constructor(
//    private val apiService: SDUIApiService
//) : FlightRepository {
//
//    override suspend fun getCheapestFlights(): Result<DivKitResponse> {
//        return try {
//            val response = apiService.getCheapestFlights()
//            if (response.isSuccessful) {
//                response.body()?.let {
//                    Result.success(it)
//                } ?: Result.failure(Exception("Empty response"))
//            } else {
//                Result.failure(Exception("API Error: ${response.code()}"))
//            }
//        } catch (e: Exception) {
//            Result.failure(e)
//        }
//    }
//
//    override suspend fun getMockFlightData(): Result<FlightResponse> {
//        return try {
//            val response = apiService.getMockFlightData()
//            if (response.isSuccessful) {
//                response.body()?.let {
//                    Result.success(it)
//                } ?: Result.failure(Exception("Empty response"))
//            } else {
//                Result.failure(Exception("API Error: ${response.code()}"))
//            }
//        } catch (e: Exception) {
//            Result.failure(e)
//        }
//    }
//}
//
//// ViewModel
//@HiltViewModel
//class FlightViewModel @Inject constructor(
//    private val repository: FlightRepository
//) : ViewModel() {
//
//    private val _uiState = MutableStateFlow(FlightUiState())
//    val uiState: StateFlow<FlightUiState> = _uiState.asStateFlow()
//
//    private val _divKitData = MutableStateFlow<DivKitResponse?>(null)
//    val divKitData: StateFlow<DivKitResponse?> = _divKitData.asStateFlow()
//
//    init {
//        loadFlightData()
//    }
//
//    private fun loadFlightData() {
//        viewModelScope.launch {
//            _uiState.value = _uiState.value.copy(isLoading = true)
//
//            // Try DiviKit first, fallback to mock data
//            repository.getCheapestFlights()
//                .onSuccess { divKitResponse ->
//                    _divKitData.value = divKitResponse
//                    _uiState.value = _uiState.value.copy(
//                        isLoading = false,
//                        useDivKit = true
//                    )
//                }
//                .onFailure {
//                    // Fallback to mock data
//                    loadMockData()
//                }
//        }
//    }
//
//    private suspend fun loadMockData() {
//        repository.getMockFlightData()
//            .onSuccess { flightResponse ->
//                _uiState.value = _uiState.value.copy(
//                    isLoading = false,
//                    flightData = flightResponse,
//                    useDivKit = false,
//                    error = null
//                )
//            }
//            .onFailure { error ->
//                _uiState.value = _uiState.value.copy(
//                    isLoading = false,
//                    error = error.message,
//                    useDivKit = false
//                )
//            }
//    }
//
//    fun retry() {
//        loadFlightData()
//    }
//}
//
//data class FlightUiState(
//    val isLoading: Boolean = false,
//    val flightData: FlightResponse? = null,
//    val error: String? = null,
//    val useDivKit: Boolean = false
//)
//
//// Hilt Module
////@Module
////@InstallIn(SingletonComponent::class)
////object NetworkModule {
////
////    @Provides
////    @Singleton
////    fun provideOkHttpClient(): OkHttpClient {
////        return OkHttpClient.Builder()
////            .addInterceptor(HttpLoggingInterceptor().apply {
////                level = HttpLoggingInterceptor.Level.BODY
////            })
////            .connectTimeout(30, TimeUnit.SECONDS)
////            .readTimeout(30, TimeUnit.SECONDS)
////            .build()
////    }
////
////    @Provides
////    @Singleton
////    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
////        return Retrofit.Builder()
////            .baseUrl("https://api.flightbooking.com/") // Replace with actual API URL
////            .client(okHttpClient)
////            .addConverterFactory(GsonConverterFactory.create())
////            .build()
////    }
////
////    @Provides
////    @Singleton
////    fun provideFlightApiService(retrofit: Retrofit): FlightApiService {
////        return retrofit.create(FlightApiService::class.java)
////    }
////
////    @Binds
////    @Singleton
////    abstract fun bindFlightRepository(
////        flightRepositoryImpl: FlightRepositoryImpl
////    ): FlightRepository
////}
//
//// DiviKit Integration Helper
//@Module
//@InstallIn(SingletonComponent::class)
//object DivKitModule {
//
//    @Provides
//    @Singleton
//    fun provideDivKitHelper(@ApplicationContext context: Context): DivKitHelper {
//        return DivKitHelper(context)
//    }
//}
//
//// Enhanced DiviKit Integration Helper
//@Singleton
//class DivKitHelper @Inject constructor(
//    @ApplicationContext private val context: Context
//) {
//
//    private val divImageLoader = object : DivImageLoader {
//        override fun loadImage(imageUrl: String, callback: DivImageLoader.Callback): Disposable {
//            // Use Glide to load images
//            val target = object : CustomTarget<Drawable>() {
//                override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
//                    callback.onSuccess(resource)
//                }
//
//                override fun onLoadCleared(placeholder: Drawable?) {
//                    callback.onError()
//                }
//
//                override fun onLoadFailed(errorDrawable: Drawable?) {
//                    callback.onError()
//                }
//            }
//
//            Glide.with(context)
//                .load(imageUrl)
//                .into(target)
//
//            return object : Disposable {
//                override fun dispose() {
//                    Glide.with(context).clear(target)
//                }
//            }
//        }
//    }
//
//    fun createDiv2Context(lifecycleOwner: LifecycleOwner): Div2Context {
//        return Div2Context(
//            baseContext = context as ApplicationContext,
//            imageLoader = divImageLoader,
//            lifecycleOwner = lifecycleOwner,
//        )
//    }
//
//    fun createDivView(divData: DivData, div2Context: Div2Context): Div2View {
//        AndroidView(
//            factory = { ctx ->
//                Div2View(ctx).apply {
//                    setData(divData, DivDataTag("text_card"))
//                }
//            },
//            modifier = Modifier.fillMaxSize()
//        )
//    }
//}
//
//// Compose UI Components
//@Composable
//fun FlightBookingScreen() {
//    val viewModel: FlightViewModel = hiltViewModel()
//    val uiState by viewModel.uiState.collectAsState()
//    val divKitData by viewModel.divKitData.collectAsState()
//
//    when {
//        uiState.isLoading -> {
//            LoadingScreen()
//        }
//
//        uiState.error != null -> {
//            ErrorScreen(
//                error = uiState.error!!,
//                onRetry = { viewModel.retry() }
//            )
//        }
//
//        uiState.useDivKit && divKitData != null -> {
//            DivKitFlightScreen(divKitData = divKitData!!.card)
//        }
//
//        uiState.flightData != null -> {
//            NativeFlightScreen(flightData = uiState.flightData!!)
//        }
//    }
//}
//
//@Composable
//fun DivKitFlightScreen(divKitData: DivData) {
//    val context = LocalContext.current
//    val divKitHelper = remember { DivKitHelper(context) }
//
//    AndroidView(
//        factory = { divKitHelper.createDivView(divKitData) },
//        modifier = Modifier.fillMaxSize()
//    )
//}
//
//@Composable
//fun NativeFlightScreen(flightData: FlightResponse) {
//    LazyVerticalGrid(
//        columns = GridCells.Fixed(2),
//        contentPadding = PaddingValues(16.dp),
//        horizontalArrangement = Arrangement.spacedBy(12.dp),
//        verticalArrangement = Arrangement.spacedBy(12.dp),
//        modifier = Modifier.fillMaxSize()
//    ) {
//        item(span = { GridItemSpan(2) }) {
//            Text(
//                text = "Cheapest Fares From ${flightData.fromCity}",
//                style = MaterialTheme.typography.headlineSmall,
//                fontWeight = FontWeight.Bold,
//                modifier = Modifier.padding(bottom = 8.dp)
//            )
//        }
//
//        items(flightData.destinations) { destination ->
//            FlightDestinationCard(destination = destination)
//        }
//    }
//}
//
//@Composable
//fun FlightDestinationCard(destination: FlightDestination) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(200.dp),
//        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
//        shape = RoundedCornerShape(12.dp)
//    ) {
//        Box(modifier = Modifier.fillMaxSize()) {
//            AsyncImage(
//                model = destination.imageUrl,
//                contentDescription = destination.name,
//                contentScale = ContentScale.Crop,
//                modifier = Modifier.fillMaxSize()
//            )
//
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(
//                        Brush.verticalGradient(
//                            colors = listOf(
//                                Color.Transparent,
//                                Color.Black.copy(alpha = 0.7f)
//                            )
//                        )
//                    )
//            )
//
//            Column(
//                modifier = Modifier
//                    .align(Alignment.BottomStart)
//                    .padding(16.dp)
//            ) {
//                Text(
//                    text = destination.name,
//                    style = MaterialTheme.typography.titleMedium,
//                    color = Color.White,
//                    fontWeight = FontWeight.Bold
//                )
//                Text(
//                    text = destination.date,
//                    style = MaterialTheme.typography.bodySmall,
//                    color = Color.White.copy(alpha = 0.9f)
//                )
//                Text(
//                    text = "${destination.currency}${destination.price}",
//                    style = MaterialTheme.typography.titleLarge,
//                    color = Color.White,
//                    fontWeight = FontWeight.Bold
//                )
//            }
//        }
//    }
//}
//
//@Composable
//fun LoadingScreen() {
//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.spacedBy(16.dp)
//        ) {
//            CircularProgressIndicator()
//            Text(
//                text = "Loading flight data...",
//                style = MaterialTheme.typography.bodyLarge
//            )
//        }
//    }
//}
//
//@Composable
//fun ErrorScreen(error: String, onRetry: () -> Unit) {
//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.spacedBy(16.dp)
//        ) {
//            Icon(
//                imageVector = Icons.Default.Error,
//                contentDescription = "Error",
//                tint = MaterialTheme.colorScheme.error,
//                modifier = Modifier.size(48.dp)
//            )
//            Text(
//                text = "Something went wrong",
//                style = MaterialTheme.typography.titleMedium
//            )
//            Text(
//                text = error,
//                style = MaterialTheme.typography.bodyMedium,
//                textAlign = TextAlign.Center,
//                modifier = Modifier.padding(horizontal = 32.dp)
//            )
//            Button(onClick = onRetry) {
//                Text("Retry")
//            }
//        }
//    }
//}
//
//// Sample DiviKit JSON Structure
///*
//{
//  "card": {
//    "log_id": "flight_cheapest_fares",
//    "states": [
//      {
//        "state_id": 0,
//        "div": {
//          "type": "container",
//          "orientation": "vertical",
//          "paddings": {
//            "left": 16,
//            "right": 16,
//            "top": 16,
//            "bottom": 16
//          },
//          "items": [
//            {
//              "type": "text",
//              "text": "Cheapest Fares From New Delhi",
//              "font_size": 24,
//              "font_weight": "bold",
//              "margins": {
//                "bottom": 16
//              }
//            },
//            {
//              "type": "grid",
//              "column_count": 2,
//              "column_span": 2,
//              "content_alignment_horizontal": "center",
//              "items": [
//                {
//                  "type": "container",
//                  "orientation": "vertical",
//                  "background": [
//                    {
//                      "type": "image_background",
//                      "image_url": "https://example.com/bathinda.jpg"
//                    }
//                  ],
//                  "corner_radius": 12,
//                  "height": {
//                    "type": "fixed",
//                    "value": 200
//                  },
//                  "margins": {
//                    "right": 6,
//                    "bottom": 12
//                  },
//                  "items": [
//                    {
//                      "type": "text",
//                      "text": "Bathinda",
//                      "font_size": 18,
//                      "font_weight": "bold",
//                      "text_color": "#FFFFFF"
//                    },
//                    {
//                      "type": "text",
//                      "text": "Thu, 25 Sep",
//                      "font_size": 14,
//                      "text_color": "#E0E0E0"
//                    },
//                    {
//                      "type": "text",
//                      "text": "₹1,680",
//                      "font_size": 20,
//                      "font_weight": "bold",
//                      "text_color": "#FFFFFF"
//                    }
//                  ]
//                }
//              ]
//            }
//          ]
//        }
//      }
//    ]
//  }
//}
//*/
//
//// Theme