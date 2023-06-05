import androidx.recyclerview.widget.RecyclerView
import com.codingstuff.loginandsignup.EventPageData

class ItemAdapter(private val items:ArrayList<EventPageData>): RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    private var onClickListener: OnClickListener? = null

}