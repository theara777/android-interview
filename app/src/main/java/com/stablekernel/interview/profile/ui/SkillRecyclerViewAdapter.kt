package com.stablekernel.interview.profile.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.stablekernel.interview.databinding.ItemSkillBinding
import kotlinx.android.synthetic.main.item_skill.view.*

class SkillRecyclerViewAdapter() : RecyclerView.Adapter<SkillViewHolder>() {

    var data = listOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            SkillViewHolder(ItemSkillBinding.inflate(LayoutInflater.from(parent.context)))

    override fun onBindViewHolder(holder: SkillViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() =
            data.size
}

class SkillViewHolder(private val binding: ItemSkillBinding) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.viewholder = this
    }

    fun bind(skill: String) {
        binding.skill = skill
    }

    fun toggle() {
        binding.root.skill_checkbox.toggle()
    }
}