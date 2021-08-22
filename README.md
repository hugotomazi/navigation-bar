# navigation-bar

Navigation Bar plugin for Capacitor

## Install

```bash
npm install navigation-bar
npx cap sync
```

## API

<docgen-index>

* [`show()`](#show)
* [`hide()`](#hide)
* [`setColor(...)`](#setcolor)
* [`getColor()`](#getcolor)
* [`addListener(...)`](#addlistener)
* [`addListener(...)`](#addlistener)
* [`addListener(...)`](#addlistener)
* [Interfaces](#interfaces)
* [Enums](#enums)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### show()

```typescript
show() => any
```

Display the navigation bar.

**Returns:** <code>any</code>

--------------------


### hide()

```typescript
hide() => any
```

Hide the navigation bar.

**Returns:** <code>any</code>

--------------------


### setColor(...)

```typescript
setColor(options: ColorParameters) => any
```

Change the color of the navigation bar.

| Param         | Type                                                        |
| ------------- | ----------------------------------------------------------- |
| **`options`** | <code><a href="#colorparameters">ColorParameters</a></code> |

**Returns:** <code>any</code>

--------------------


### getColor()

```typescript
getColor() => any
```

Gets the current color of the navigation bar in Hexadecimal.

**Returns:** <code>any</code>

--------------------


### addListener(...)

```typescript
addListener(event: NavigationBarPluginEvents.SHOW, listenerFunc: () => void) => PluginListenerHandle
```

Event fired after navigation bar is displayed

| Param              | Type                                                                                 | Description |
| ------------------ | ------------------------------------------------------------------------------------ | ----------- |
| **`event`**        | <code><a href="#navigationbarpluginevents">NavigationBarPluginEvents.SHOW</a></code> | The event   |
| **`listenerFunc`** | <code>() =&gt; void</code>                                                           | Callback    |

**Returns:** <code><a href="#pluginlistenerhandle">PluginListenerHandle</a></code>

--------------------


### addListener(...)

```typescript
addListener(event: NavigationBarPluginEvents.HIDE, listenerFunc: () => void) => PluginListenerHandle
```

Event fired after navigation bar is hidden

| Param              | Type                                                                                 | Description |
| ------------------ | ------------------------------------------------------------------------------------ | ----------- |
| **`event`**        | <code><a href="#navigationbarpluginevents">NavigationBarPluginEvents.HIDE</a></code> | The event   |
| **`listenerFunc`** | <code>() =&gt; void</code>                                                           | Callback    |

**Returns:** <code><a href="#pluginlistenerhandle">PluginListenerHandle</a></code>

--------------------


### addListener(...)

```typescript
addListener(event: NavigationBarPluginEvents.COLOR_CHANGE, listenerFunc: (returnObject: { color: string; }) => void) => PluginListenerHandle
```

Event fired after navigation bar color is changed

| Param              | Type                                                                                         | Description |
| ------------------ | -------------------------------------------------------------------------------------------- | ----------- |
| **`event`**        | <code><a href="#navigationbarpluginevents">NavigationBarPluginEvents.COLOR_CHANGE</a></code> | The event   |
| **`listenerFunc`** | <code>(returnObject: { color: string; }) =&gt; void</code>                                   | Callback    |

**Returns:** <code><a href="#pluginlistenerhandle">PluginListenerHandle</a></code>

--------------------


### Interfaces


#### ColorParameters

| Prop              | Type                 | Description                                                               |
| ----------------- | -------------------- | ------------------------------------------------------------------------- |
| **`color`**       | <code>string</code>  | Sets the new color of the navigation bar.                                 |
| **`darkButtons`** | <code>boolean</code> | Sets whether the default navigation bar buttons should be black or white. |


#### PluginListenerHandle

| Prop         | Type                      |
| ------------ | ------------------------- |
| **`remove`** | <code>() =&gt; any</code> |


### Enums


#### NavigationBarPluginEvents

| Members            | Value                        | Description                                  |
| ------------------ | ---------------------------- | -------------------------------------------- |
| **`SHOW`**         | <code>'onShow'</code>        | Called after the navigation bar is displayed |
| **`HIDE`**         | <code>'onHide'</code>        | Called after navigation bar is hidden        |
| **`COLOR_CHANGE`** | <code>'onColorChange'</code> | Called after navigation bar color is changed |

</docgen-api>
