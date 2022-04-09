/*
 * Copyright 2022 CASL0
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.co.casl0.android.simpleappblocker.blocklog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import jp.co.casl0.android.simpleappblocker.databinding.FragmentBlocklogBinding

class BlockLogFragment : Fragment() {

    private var _binding: FragmentBlocklogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val blockLogViewModel =
            ViewModelProvider(this).get(BlockLogViewModel::class.java)

        _binding = FragmentBlocklogBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val recyclerView = binding.blockLogRecyclerView
        val adapter = BlockLogListAdapter(context, listOf())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        blockLogViewModel.blockPacketInfoList.observe(viewLifecycleOwner) {
            if (it != null) {
                adapter.blockLogList = it
                recyclerView.adapter?.notifyDataSetChanged()
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}