package com.example.kocopepo.tipsplitterintegrationexample;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @author Martin Kocour
 *         created on 10.5.17
 */

class ViewDataAdapter extends RecyclerView.Adapter<ViewDataAdapter.ViewHolder> {

    private Context mContext;
    private Cursor mCursor;

    public ViewDataAdapter(Context context) {
        mContext = context;
    }

    public void setCursor(Cursor cursor) {
        if (mCursor != null) {
            mCursor.close();
        }
        mCursor = cursor;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (mCursor == null || !mCursor.moveToPosition(position)) {
            return;
        }
        PaymentInfo info = new PaymentInfo();
        info.loadFromCursor(mCursor);
        holder.bind(info);
    }

    @Override
    public int getItemCount() {
        if (mCursor != null && !mCursor.isClosed()) {
            return mCursor.getCount();
        }
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView employee;
        TextView tip;

        public ViewHolder(View itemView) {
            super(itemView);
            employee = (TextView) itemView.findViewById(R.id.employee);
            tip = (TextView) itemView.findViewById(R.id.tip);
        }

        public void bind(PaymentInfo info) {
            employee.setText(info.employee);
            tip.setText(String.valueOf(info.tip));
        }
    }
}
