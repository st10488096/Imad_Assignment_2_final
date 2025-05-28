package vcmsa.ci.imadassignment2final

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Theresults : AppCompatActivity() {

var myscore: TextView? = null
    var therest: TextView? = null
    var myfeedback: TextView? = null
    var reviewbutton: Button? = null
    var leavebutton: Button? = null



    val MyQuestions = arrayOf("The ANC party was formed in 1972.", "Nelson Mandela was the first black president of South Africa",
        "Solomon Mahlangu's death was caused by an asasination", "The Apartheid law was abolished in 1990. ", "Nelson Mandela passed away in 05 December 2013.")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_theresults)

        myscore = findViewById<View>(R.id.myscore) as TextView
        therest = findViewById<View>(R.id.therest) as TextView
        myfeedback = findViewById<View>(R.id.myfeedback) as TextView
        reviewbutton = findViewById<View>(R.id.reviewbutton) as Button
        leavebutton = findViewById<View>(R.id.leavebutton) as Button

        val score = intent.getIntExtra("your score", 0)
        val TheQuestion = intent.getStringArrayExtra("Questions")


        myscore!!.text = "That was quick! Here is your score: $score / ${TheQuestion!!.size}"
        if (score < 3){
           therest!!.text = "Your could've done better! Needs Improvement."
        } else if (score < 5){
            therest!!.text = "Well done! Just a few more marks away from perfection!"
        } else{
            therest!!.text = "Amazing work, WOW! Keep it up."
        }

        reviewbutton!!.setOnClickListener {

            val MyQuestion = "${MyQuestions[1]}- False\n${MyQuestions[0]}- True\n${MyQuestions[1]}- False\n${MyQuestions[1]}- False\n${MyQuestions[0]}- True"
            myfeedback!!.text = MyQuestion
        }

        leavebutton!!.setOnClickListener {
            finishAffinity()
        }












        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}