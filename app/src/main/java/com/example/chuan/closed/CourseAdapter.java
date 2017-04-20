package com.example.chuan.closed;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    private ArrayList<Course> Course;
    public static final String course_ITEM = "course";

    public CourseAdapter(ArrayList<Course> Course) {
        this.Course = Course;
    }

    /**
     * This function is called only enough times to cover the screen with views.  After
     * that point, it recycles the views when scrolling is done.
     * @param parent the intended parent object (our RecyclerView)
     * @param viewType unused in our function (enables having different kinds of views in the same RecyclerView)
     * @return the new ViewHolder we allocate
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // a LayoutInflater turns a layout XML resource into a View object.
        final View CourseListItem = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.course_list_item, parent, false);
        return new ViewHolder(CourseListItem);
    }

    /**
     * This function gets called each time a ViewHolder needs to hold data for a different
     * position in the list.  We don't need to create any views (because we're recycling), but
     * we do need to update the contents in the views.
     * @param holder the ViewHolder that knows about the Views we need to update
     * @param position the index into the array of Course
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Course mCourse = Course.get(position);

        holder.crn.setText(mCourse.getCrn());
        holder.number.setText(mCourse.getSubject() + " " + mCourse.getNumber());
        holder.status.setText(mCourse.getStatus());
        switch (mCourse.getStatus()){
            case "Closed":
                holder.statusIcon.setImageResource(R.drawable.sectionClosed);
                break;
            case "Open":
                holder.statusIcon.setImageResource(R.drawable.sectionOpen);
                break;
            case "Pending":
                holder.statusIcon.setImageResource(R.drawable.sectionPending);
                break;
            case "Restricted":
                holder.statusIcon.setImageResource(R.drawable.sectionRestricted);
                break;
            default:
                holder.statusIcon.setImageResource(R.drawable.sectionUnknown);
                break;
        }

    }

    /**
     * RecyclerView wants to know how many list items there are, so it knows when it gets to the
     * end of the list and should stop scrolling.
     * @return the number of Course in the array.
     */
    @Override
    public int getItemCount() {
        return Course.size();
    }

    /**
     * A ViewHolder class for our adapter that 'caches' the references to the
     * subviews, so we don't have to look them up each time.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView status;
        public TextView number;
        public TextView crn;
        public ImageView statusIcon;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            number = (TextView) itemView.findViewById(R.id.number);
            crn = (TextView) itemView.findViewById(R.id.crn);
            status = (TextView) itemView.findViewById(R.id.status);
            statusIcon = (ImageView) itemView.findViewById(R.id.statusIcon);
        }
    }
}
