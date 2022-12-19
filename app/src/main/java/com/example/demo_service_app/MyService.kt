package com.example.demo_service_app

import android.annotation.SuppressLint
import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.CountDownTimer
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.demo_service_app.MyApp.Companion.CHANNEL_ID

class MyService : Service() {
    companion object{
         val TAG = javaClass::class.java.name
    }
    override fun onBind(intent: Intent?): IBinder? {
        //nếu không sử dụng sử dụng bound sẻrvice thì return null
        return null
    }
    override fun onUnbind(intent: Intent?): Boolean {
        return super.onUnbind(intent)
        //huy lien ket voi service
    }
    //START_STICKY khi bi hủy vì tràn bộ nhớ vfa khi thiết bị đủ bộ nhớ hệ thống sẽ yêu cầu khởi tạo lại với giá trị từ đầu
    //START_NOT_STICKY ---------------------sẽ hủy hoàn toàn service
    //START_REDELIVER_INTENT khi bị hủy sẽ ngay lập tức yêu cầu khởi tạo lại service và tiếp túc tiến trình đang dở của service
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val str = intent?.getStringExtra("DATA_INTENT")
        sendNotification(str)
        setRuntime()
        return START_NOT_STICKY
    }



    override fun onCreate() {
        super.onCreate()
        Log.e(TAG, "onCreate: ", )
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy: ", )
    }
    private fun sendNotification(str: String?) {
        val intent = Intent(this,MainActivity::class.java)
        val pIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT)
        val notifi = NotificationCompat.Builder(this,CHANNEL_ID)
            .setContentTitle("Service")
            .setContentText(str)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentIntent(pIntent)
            .build()
        startForeground(1,notifi)
    }

    private fun setRuntime(){
        var a =0
            val timer = object :CountDownTimer(10000,1000){
                override fun onTick(millisUntilFinished: Long) {
                }

                override fun onFinish() {
                    a++
                    Log.e(TAG, "onTick: ${a}", )
                    start()
                }

            }
        timer.start()
    }

}