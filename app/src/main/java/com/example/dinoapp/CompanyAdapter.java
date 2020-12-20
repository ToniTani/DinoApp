package com.example.dinoapp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dinoapp.model.ExampleCompany;

import java.util.ArrayList;
import java.util.List;

public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.CompanyViewHolder> implements Filterable {

    private Context mContext;
    private ArrayList<ExampleCompany> mCompanyList;
    private ArrayList<ExampleCompany> mCompanyListFull;
    public CompanyAdapter(Context context, ArrayList<ExampleCompany> companyList) {
    mContext = context;
    mCompanyList = companyList;
    mCompanyListFull = new ArrayList<>(companyList);
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
        String registrationDate = currentCompany.getRegistrationDate();

        holder.mName.setText(name);
        holder.mBusinessId.setText("Business ID: " + businessId);
        holder.mCompanyForm.setText(companyForm);
        holder.mRegistrationDate.setText("Date of Registration: " + registrationDate);

        boolean isExpanded = mCompanyList.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return mCompanyList.size();
    }

    @Override
    public Filter getFilter() {
        return companyFilter;
    }
    private Filter companyFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ExampleCompany> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(mCompanyListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (ExampleCompany item : mCompanyListFull) {
                    if (item.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mCompanyList.clear();
            mCompanyList.addAll((List) results.values);
            notifyDataSetChanged();

        }
    };


    public class CompanyViewHolder extends RecyclerView.ViewHolder {

            public TextView mName;
            public TextView mBusinessId;
            public TextView mCompanyForm;
            public TextView mRegistrationDate;
            RelativeLayout expandableLayout;

            public CompanyViewHolder (View itemView) {
                super(itemView);
                mName = itemView.findViewById(R.id.name);
                mBusinessId = itemView.findViewById(R.id.businessId);
                mCompanyForm = itemView.findViewById(R.id.companyForm);
                mRegistrationDate = itemView.findViewById(R.id.registrationDate);
                expandableLayout = itemView.findViewById(R.id.expandableLayout);

                mName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ExampleCompany exampleCompany = mCompanyList.get(getAdapterPosition());
                        exampleCompany.setExpanded(!exampleCompany.isExpanded());
                        notifyItemChanged(getAdapterPosition());
                    }
                });
            }
    }
}
