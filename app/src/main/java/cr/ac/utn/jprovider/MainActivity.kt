package cr.ac.utn.jprovider

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import cr.ac.utn.jprovider.util.util

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnSignIn: Button = findViewById(R.id.btnSignIn_main)

        btnSignIn.setOnClickListener(View.OnClickListener { view ->
            util.OpenActivity(this, ProvidersActivity::class.java)
        })
    }
}
