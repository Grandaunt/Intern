package com.example.win.newintern3.UI.MainFragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.win.newintern3.Base.BaseQuickAdapter;
import com.example.win.newintern3.Adpter.StudyAdapter;
import com.example.win.newintern3.Entity.AllEducationInfoEndtity;
import com.example.win.newintern3.R;
import com.example.win.newintern3.UI.TwoModule.SMainActivity;
import com.example.win.newintern3.Utils.JsonUtils;
import com.example.win.newintern3.Utils.URLConfig;
import com.example.win.newintern3.Utils.logger.Logger;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TwoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TwoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TwoFragment extends Fragment {
//    RecyclerView recyclerStudy;
//    RecyclerView recyclerJob;
    private BaseQuickAdapter adapter;
    private Intent intent;
    List<AllEducationInfoEndtity.EducationEntity.CategoryinfoEntity> mData;
    private OnFragmentInteractionListener mListener;

    public TwoFragment() {
        // Required empty public constructor
    }


    public static TwoFragment newInstance(String param1, String param2) {
        TwoFragment fragment = new TwoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_two, container, false);
//        initdata();
        initview(view);
        return view;
    }
    private void initview(View view) {

//        recyclerStudy = (RecyclerView) view.findViewById(R.id.recycler_open_class);
//        recyclerStudy.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerStudy.setHasFixedSize(false);
//        recyclerStudy.setAdapter(adapter);


//        adapter = new StudyAdapter(R.layout.item_video_class,mData);
//        adapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position, Object item) {
//                intent = new Intent(getActivity(), SMainActivity.class);
//                intent.putExtra("vodeoId", "123");
//                startActivity(intent);
//
//            }
//        });

    }

//    private void initdata() {
//        RequestParams params = new RequestParams(URLConfig.Pro_jpbAPI);
//        params.addParameter("action", "getalleducation");
//        Logger.d(params);
//        x.http().post(params, new Callback.CommonCallback<String>() {
//            @Override
//            public void onSuccess(String result) {
//                Logger.d(result);
//                AllEducationInfoEndtity allEducationInfoEndtity= JsonUtils.getPerson(result, AllEducationInfoEndtity.class);
//                if (allEducationInfoEndtity.getCode().equals("200")) {
//                    adapter.addData(allEducationInfoEndtity.getEducation());
//                }
//
//            }
//
//            @Override
//            public void onError(Throwable ex, boolean isOnCallback) {
//
//            }
//
//            @Override
//            public void onCancelled(CancelledException cex) {
//
//            }
//
//            @Override
//            public void onFinished() {
//
//            }
//        });
//    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
