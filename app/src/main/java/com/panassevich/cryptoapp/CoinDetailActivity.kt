package com.panassevich.cryptoapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.panassevich.cryptoapp.databinding.ActivityCoinDetailBinding
import com.panassevich.cryptoapp.databinding.ActivityCoinPriceListBinding
import com.squareup.picasso.Picasso

class CoinDetailActivity : AppCompatActivity() {
    private lateinit var viewModel: CoinViewModel
    private lateinit var binding: ActivityCoinDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoinDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fromSymbol = intent.getStringExtra(EXTRA_FROM_SYMBOL)
        if (fromSymbol == null) {
            finish()
            return
        }
        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        viewModel.getDetailInfo(fromSymbol).observe(this) {
            with(binding) {
                tvDetailedPrice.text =
                    String.format(resources.getString(R.string.detailed_price_template), it.price)
                tvMinDayPrice.text = String.format(
                    resources.getString(R.string.detailed_min_day_price_template),
                    it.lowDay
                )
                tvMaxDayPrice.text = String.format(
                    resources.getString(R.string.detailed_max_day_price_template),
                    it.highDay
                )
                lastContract.text = String.format(
                    resources.getString(R.string.detailed_last_contract_place_template),
                    it.lastMarket
                )
                lastUpdate.text = String.format(
                    resources.getString(R.string.detailed_last_update_template),
                    it.lastUpdate
                )
                tvDetailedFromSym.text = it.fromSymbol
                tvDetailedToSym.text = it.toSymbol
                Picasso.get().load(it.getFullImageUrl()).into(ivDetailedCoinLogo)
            }
        }
    }

    companion object {
        private const val EXTRA_FROM_SYMBOL = "fSym"
        fun newIntent(context: Context, fromSymbol: String): Intent {
            val intent = Intent(context, CoinDetailActivity::class.java)
            intent.putExtra(EXTRA_FROM_SYMBOL, fromSymbol)
            return intent
        }
    }
}