import { WebPlugin } from '@capacitor/core';
import type { NavigationBarPlugin } from './definitions';

export class NavigationBarWeb extends WebPlugin implements NavigationBarPlugin {

  async show(): Promise<void> {
    return new Promise<void>((resolve) => {
      console.log('Navigation Bar Showed!')
      resolve()
    })
  }

  async hide(): Promise<void> {
    return new Promise<void>((resolve) => {
      console.log('Navigation Bar Hided!')
      resolve()
    })
  }

  async setColor(options: { color: string, darkButtons?: boolean }): Promise<void> {
    return new Promise<void>((resolve) => {
      console.log(`Navigation Bar color changed to ${options.color ? options.color : '#FFFFFF'} : Dark Buttons: ${options.darkButtons ? 'YES' : 'NO'}`)
      resolve()
    })
  }

  async getColor(): Promise<{ color: string }> {
    return new Promise<{ color: string }>((resolve) => {
      resolve({ color: '#FFFFFF' })
    })
  }

}
