import { defineStore } from 'pinia';
import { ref } from 'vue';
import { AuthManager } from '@/manager/auth/AuthManager.js';

export const useAuthStore = defineStore('useAuthStore', () => {
  const auth = ref(
    localStorage.getItem(AuthManager.AUTH_KEY)
      ? JSON.parse(localStorage.getItem(AuthManager.AUTH_KEY))
      : null
  );

  function deleteAuth() {
    auth.value = null;
    localStorage.removeItem(AuthManager.AUTH_KEY);
  }

  function getAuth() {
    return auth;
  }

  function setAuth(payload) {
    const authInfo = {
      userId: payload.userId,
      role: payload.role,
      isRequireInfo: payload.requireUserInfo === 'true'
    };
    auth.value = authInfo;
    localStorage.setItem(AuthManager.AUTH_KEY, JSON.stringify(authInfo));
  }

  function updateIsRequireInfo(isRequire) {
    auth.value.isRequireInfo = isRequire;
    localStorage.setItem(AuthManager.AUTH_KEY, JSON.stringify(auth.value));
  }

  return {
    getAuth,
    deleteAuth,
    setAuth,
    updateIsRequireInfo
  };
});
