package cr.ac.utn.jprovider

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import cr.ac.utn.jprovider.util.util

class ProvidersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_providers)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnAdd: Button = findViewById(R.id.btnAdd_providers)
        val btnSendRequest: Button = findViewById(R.id.btnSendRequest_providers)

        btnAdd.setOnClickListener(View.OnClickListener { view ->
            util.OpenActivity(this, AddProviderActivity::class.java)
        })

        btnSendRequest.setOnClickListener(View.OnClickListener { view ->
            util.OpenActivity(this, SendRequestActivity::class.java)
        })
    }
}
