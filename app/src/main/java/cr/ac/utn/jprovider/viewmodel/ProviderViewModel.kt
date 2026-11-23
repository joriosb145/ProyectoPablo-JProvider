package cr.ac.utn.jprovider.viewmodel

import androidx.lifecycle.ViewModel
import cr.ac.utn.jprovider.data.memory.MemoryProviderRepository
import cr.ac.utn.jprovider.domain.model.OrderRequest
import cr.ac.utn.jprovider.domain.model.Provider
import cr.ac.utn.jprovider.domain.repository.IProviderRepository

class ProviderViewModel : ViewModel() {
    companion object {
        private var repository: IProviderRepository

        init {
            repository = MemoryProviderRepository()
        }

        fun getProviders(): List<Provider> {
            return repository.getProviders()
        }

        fun getProviderById(id: String): Provider? {
            return repository.getProviderById(id)
        }

        fun saveProvider(provider: Provider) {
            repository.insertProvider(provider)
        }

        fun updateProvider(provider: Provider) {
            repository.updateProvider(provider)
        }

        fun removeProvider(id: String) {
            repository.deleteProvider(id)
        }

        fun getOrderRequests(): List<OrderRequest> {
            return repository.getOrderRequests()
        }

        fun saveOrderRequest(request: OrderRequest) {
            repository.insertOrderRequest(request)
        }
    }
}
