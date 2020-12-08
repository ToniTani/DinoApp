package com.example.dinoapp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dinoapp.model.ExampleCompany;

import java.util.ArrayList;

public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.CompanyViewHolder> {

    private Context mContext;
    private ArrayList<ExampleCompany> mCompanyList;

    public CompanyAdapter(Context context, ArrayList<ExampleCompany> companyList) {
    mContext = context;
    mCompanyList = companyList;
    }

    @NonNull
    @Override
    public CompanyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.example_company, parent, false );
        return new CompanyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CompanyViewHolder holder, int position) {
        ExampleCompany currentCompany = mCompanyList.get(position);

        String name = currentCompany.getName();
        String businessId = currentCompany.getBusinessId();
        String companyForm = currentCompany.getCompanyForm();

        holder.mName.setText(name);
        holder.mBusinessId.setText(businessId);
        holder.mCompanyForm.setText(companyForm);
    }

    @Override
    public int getItemCount() {
        return mCompanyList.size();
    }


    public class CompanyViewHolder extends RecyclerView.ViewHolder {

            public TextView mName;
            public TextView mBusinessId;
            public TextView mCompanyForm;

            public CompanyViewHolder (View itemView) {
                super(itemView);
                mName = itemView.findViewById(R.id.name);
                mBusinessId = itemView.findViewById(R.id.businessId);
                mCompanyForm = itemView.findViewById(R.id.companyForm);
            }
    }
}
