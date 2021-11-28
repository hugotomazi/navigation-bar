import { Component } from '@angular/core';
import { NavigationBar, NavigationBarPluginEvents } from 'navigation-bar';
@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {
  currentColor: string
  currentStatus: string
  isTransparent: boolean = false
  constructor() {}

  ngAfterViewInit() {
    NavigationBar.getColor().then(ret => {
      this.currentColor = ret.color
    })

    NavigationBar.addListener(NavigationBarPluginEvents.SHOW, () => {
      this.currentStatus = 'SHOW'
    })

    NavigationBar.addListener(NavigationBarPluginEvents.HIDE, () => {
      this.currentStatus = 'HIDE'
    })

    NavigationBar.addListener(NavigationBarPluginEvents.COLOR_CHANGE, (ret) => {
      this.currentColor = ret.color
      this.currentStatus = 'COLOR_CHANGE'
    })
  }

  openNavigationBar() {
    NavigationBar.show()
  }

  hideNavigationBar() {
    NavigationBar.hide()
  }

  changeNavigationBarColor() {
    NavigationBar.setColor({ color: '#FF0000', darkButtons: true })
    setTimeout(() => {
       NavigationBar.setColor({ color: '#44008000' })
    }, 3000)
  }

  setTransparentBackground() {
    this.isTransparent = !this.isTransparent
    NavigationBar.setTransparency({ isTransparent: this.isTransparent }) 
  }
}
