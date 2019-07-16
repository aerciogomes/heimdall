import i18n from "../i18n/i18n"
import { HTTPv1 } from '../utils/Http'

const getResourcesByApi = (idApi) => {
    return HTTPv1.get('/apis/' + idApi + '/resources')
    .then(res => {

        return Promise.resolve(res.data)
    })
    .catch(error => {
        console.log('Error: ', error)
        if (error.response && error.response.status === 404) {
            return Promise.reject(new Error(i18n.t('resource_not_found')));
        }
        throw error;
    })
}

const getResource = (idApi, id) => {
    return HTTPv1.get('/apis/' + idApi + '/resources/' + id)
    .then(res => {

        return Promise.resolve(res.data)
    })
    .catch(error => {
        console.log('Error: ', error)
        if (error.response && error.response.status === 404) {
            return Promise.reject(new Error(i18n.t('resource_not_found')));
        }
        throw error;
    })
}

const save = (idApi, resource) => {
    return HTTPv1.post('/apis/' + idApi + '/resources', JSON.stringify(resource))
    .then(res => {

        return Promise.resolve(res.data)
    })
    .catch(error => {
        console.log('Error: ', error)

        if (error.response && error.response.status === 404) {
            return Promise.reject(new Error(i18n.t('resource_not_found')));
        }
        throw error;
    })
}

const update = (idApi, resource) => {
    return HTTPv1.put('/apis/' + idApi + '/resources/'+ resource.id, JSON.stringify(resource))
    .then(res => {

        return Promise.resolve(res.data)
    })
    .catch(error => {
        console.log('Error: ', error)

        if (error.response && error.response.status === 404) {
            return Promise.reject(new Error(i18n.t('resource_not_found')));
        }
        throw error;
    })
}

const remove = (idApi, idResource) => {
    return HTTPv1.delete('/apis/' + idApi + '/resources/'+ idResource)
    .then(res => {
        return Promise.resolve(res.data)
    })
    .catch(error => {
        console.log('Error: ', error)
        if (error.response && error.response.status === 404) {
            return Promise.reject(new Error(i18n.t('resource_not_found')));
        }
        throw error;
    })
}

export const resourceService = {
    getResourcesByApi,
    getResource,
    save,
    update,
    remove
}