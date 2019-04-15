package com.example.photos;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class ImageClickOnListner implements RecyclerView.OnItemTouchListener {

    private OnItemClickListener mListener;

    public interface OnItemClickListener {

         void onItemClick(View v, int position);
    }

    private GestureDetector gestureDetector;

    public ImageClickOnListner(Context context, OnItemClickListener listener) {
        mListener = listener;
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {

            @Override public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView v, MotionEvent e) {

        View child = v.findChildViewUnder(e.getX(), e.getY());
        if (child != null && mListener != null && gestureDetector.onTouchEvent(e)) {
            mListener.onItemClick(child, v.getChildAdapterPosition(child));
            return true;
        }

        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView v, MotionEvent motionEvent) { }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}