package org.iflab.ibistubydreamfactory.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.iflab.ibistubydreamfactory.R;
import org.iflab.ibistubydreamfactory.models.YellowPageDepartment;

import java.util.List;

/**
 * 绑定ListView适配器
 */
public class yellowPageDetailsAdapter extends BaseAdapter {
    private Context context;
    private List<YellowPageDepartment> yellowPageDepartmentBranchList;

    public yellowPageDetailsAdapter(Context context, List<YellowPageDepartment> yellowPageDepartmentBranchList) {
        this.context = context;
        this.yellowPageDepartmentBranchList = yellowPageDepartmentBranchList;
    }

    @Override
    public int getCount() {
        return yellowPageDepartmentBranchList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    /**
     * 绘制每个item
     *
     * @param position    点击的位置
     * @param convertView item对应的View
     * @param parent      可选的父控件
     * @return 要显示的单个item的View
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_yellow_page_depart_details, null);
            viewHolder = new ViewHolder();
            viewHolder.branchNameTextView = (TextView) convertView.findViewById(R.id.yellowPageDetails_item_textView1);
            viewHolder.telephoneNumberTextView = (TextView) convertView.findViewById(R.id.yellowPageDetails_item_textView2);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.telephoneNumberTextView.setText(yellowPageDepartmentBranchList.get(position)
                                                                                 .getTelephone());
        viewHolder.branchNameTextView.setText(yellowPageDepartmentBranchList.get(position).getName());
        return convertView;
    }

    /**
     * 起优化作用ListView的ViewHolder类，避免多次加载TextView
     */
    private class ViewHolder {
        private TextView branchNameTextView;
        private TextView telephoneNumberTextView;
    }
}

