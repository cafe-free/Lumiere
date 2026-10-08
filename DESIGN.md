---
name: Seraphic Calm
colors:
  surface: '#faf8ff'
  surface-dim: '#d9d9e4'
  surface-bright: '#faf8ff'
  surface-container-lowest: '#ffffff'
  surface-container-low: '#f3f3fe'
  surface-container: '#ededf8'
  surface-container-high: '#e7e7f3'
  surface-container-highest: '#e1e1ed'
  on-surface: '#191b23'
  on-surface-variant: '#464555'
  inverse-surface: '#2e3039'
  inverse-on-surface: '#f0f0fb'
  outline: '#777587'
  outline-variant: '#c7c4d8'
  surface-tint: '#4d44e3'
  primary: '#3525cd'
  on-primary: '#ffffff'
  primary-container: '#4f46e5'
  on-primary-container: '#dad7ff'
  inverse-primary: '#c3c0ff'
  secondary: '#855316'
  on-secondary: '#ffffff'
  secondary-container: '#ffbc76'
  on-secondary-container: '#79490b'
  tertiary: '#434853'
  on-tertiary: '#ffffff'
  tertiary-container: '#5b606b'
  on-tertiary-container: '#d7dbe8'
  error: '#ba1a1a'
  on-error: '#ffffff'
  error-container: '#ffdad6'
  on-error-container: '#93000a'
  primary-fixed: '#e2dfff'
  primary-fixed-dim: '#c3c0ff'
  on-primary-fixed: '#0f0069'
  on-primary-fixed-variant: '#3323cc'
  secondary-fixed: '#ffdcbd'
  secondary-fixed-dim: '#fcb973'
  on-secondary-fixed: '#2c1600'
  on-secondary-fixed-variant: '#683c00'
  tertiary-fixed: '#dee2ef'
  tertiary-fixed-dim: '#c2c6d3'
  on-tertiary-fixed: '#171c25'
  on-tertiary-fixed-variant: '#424751'
  background: '#faf8ff'
  on-background: '#191b23'
  surface-variant: '#e1e1ed'
typography:
  display-lg:
    fontFamily: Plus Jakarta Sans
    fontSize: 40px
    fontWeight: '600'
    lineHeight: 48px
    letterSpacing: -0.02em
  headline-lg:
    fontFamily: Plus Jakarta Sans
    fontSize: 32px
    fontWeight: '600'
    lineHeight: 40px
    letterSpacing: -0.015em
  headline-lg-mobile:
    fontFamily: Plus Jakarta Sans
    fontSize: 26px
    fontWeight: '600'
    lineHeight: 34px
    letterSpacing: -0.01em
  headline-md:
    fontFamily: Plus Jakarta Sans
    fontSize: 22px
    fontWeight: '600'
    lineHeight: 28px
    letterSpacing: -0.01em
  headline-sm:
    fontFamily: Plus Jakarta Sans
    fontSize: 18px
    fontWeight: '600'
    lineHeight: 24px
    letterSpacing: 0em
  body-lg:
    fontFamily: Plus Jakarta Sans
    fontSize: 16px
    fontWeight: '400'
    lineHeight: 26px
    letterSpacing: 0em
  body-md:
    fontFamily: Plus Jakarta Sans
    fontSize: 15px
    fontWeight: '400'
    lineHeight: 24px
    letterSpacing: 0em
  body-sm:
    fontFamily: Plus Jakarta Sans
    fontSize: 13px
    fontWeight: '400'
    lineHeight: 20px
    letterSpacing: 0.01em
  label-lg:
    fontFamily: Plus Jakarta Sans
    fontSize: 14px
    fontWeight: '500'
    lineHeight: 20px
    letterSpacing: 0.01em
  label-md:
    fontFamily: Plus Jakarta Sans
    fontSize: 12px
    fontWeight: '500'
    lineHeight: 16px
    letterSpacing: 0.02em
  label-sm:
    fontFamily: Plus Jakarta Sans
    fontSize: 11px
    fontWeight: '600'
    lineHeight: 14px
    letterSpacing: 0.03em
rounded:
  sm: 0.25rem
  DEFAULT: 0.5rem
  md: 0.75rem
  lg: 1rem
  xl: 1.5rem
  full: 9999px
spacing:
  gutter: 1rem
  gutter-mobile: 0.75rem
  margin: 1.5rem
  margin-mobile: 1.25rem
  space-xs: 0.25rem
  space-sm: 0.5rem
  space-md: 1rem
  space-lg: 1.5rem
  space-xl: 2rem
---

## Brand & Style

This design system expresses quiet intelligence, luminous warmth, and non-judgmental presence. Designed as an empathic AI companion for Android, the interface rejects cold, hyper-analytical computational motifs in favor of an ethereal, calm, and deeply human sanctuary.

The core aesthetic combines Warm Seraphic Minimalism with soft, translucent tactile layering. It feels less like an operational utility and more like an inviting journal or sacred mental clarity space. 

Visual anchors include:
- Vast, uncluttered breathing room with intentional whitespace.
- Luminous cream and warm ivory backdrops that eliminate harsh device glare.
- Electric indigo grounding accents balanced by sunrise peach transitions.
- Soft, pillowed corner radii (24dp baseline on mobile) communicating safety and tactile comfort.
- Refined geometric line weight icon sets (1.5dp–2dp stroke) that preserve an airy, serene tempo.

## Colors

The palette establishes an emotional gradient ranging from thoughtful focus to affectionate presence.

- **Background Canvas (`#FFFCF0`)**: A warm, serene ivory cream that functions as the non-emissive, eye-soothing backdrop.
- **Surface Layer (`#FFFFFF`)**: Pure optic white reserved for floating cards, input docks, and conversational message bubbles to subtly lift content off the ivory floor.
- **Primary Accent (`#4F46E5` / `#4338CA`)**: Electric Indigo. Represents cognitive clarity, deep mindfulness, and AI resonance. Used for primary CTAs, active states, and focal AI moments.
- **Secondary Accent (`#FDBA74` / `#FFEDD5`)**: Sunrise Peach. Infuses human warmth, emotional check-in cues, active voice waves, and empathetic reactions.
- **Soft Iris Surface (`#EEF2FF`)**: An ethereal tinted neutral used for non-dominant chips, AI response containers, and low-contrast surface divisions.
- **Primary Typography (`#1A1C24`)**: Deep Slate. Softened black that provides maximum contrast and legibility without harsh chromatic glare.
- **Muted Typography (`#767680`)**: Warm stone neutral for metadata, timestamps, and placeholder copy.
- **Subtle Stroke (`#E2E5EE`)**: Hairline boundary accent used selectively to establish crisp edge definition without heavy visual weight.

## Typography

The type system relies completely on **Plus Jakarta Sans**, chosen for its clean, geometric balance and soft, approachable human curves.

- **Headlines**: Set with moderate weights (600) and generous line heights, conveying relaxed poise rather than loud editorial drama.
- **Body Text**: Tuned for readability with an expanded line height (`26px` on `16px` font) to foster an unhurried, reflective reading rhythm during intimate AI conversations.
- **Numerics & Labels**: Set with slightly expanded letter-spacing to ensure crisp legibility on small Android viewports.

## Layout & Spacing

The spatial architecture is fluid and spacious, anchored to an 8dp baseline grid (with 4dp sub-steps for precise alignment). 

- **Canvas Structure**: Fixed margins of `20dp` (1.25rem) on standard phone screens protect touch targets from bezel edges. Gutters between multi-column cards remain tight at `12dp` to reinforce perceptual grouping.
- **Dynamic Breathing Room**: AI dialogue blocks leverage an asymmetrical layout: user messages align to the trailing edge with compact margins, whereas AI responses occupy full conversational widths with generous top and bottom gaps (`space-lg`) to pace cognitive intake.
- **SafeArea Compliance**: Full respect for Android system navigation bars and gesture insets, with the primary input dock elevated gracefully above the gesture pill.

## Elevation & Depth

Visual hierarchy does not use harsh, direct drop shadows. Instead, it relies on soft luminance differences and ethereal, ambient dispersion:

- **Level 0 (Canvas)**: Background ivory tint (`#FFFCF0`).
- **Level 1 (Resting Cards & Bubbles)**: Elevated pure white surfaces (`#FFFFFF`) with an ambient veil: `box-shadow: 0 4px 24px -2px rgba(26, 28, 36, 0.04), 0 1px 3px 0 rgba(26, 28, 36, 0.02)`. An imperceptible stroke (`1px solid #E2E5EE`) stabilizes card bounds.
- **Level 2 (Floating Action Docks & Menus)**: `box-shadow: 0 12px 36px -4px rgba(79, 70, 229, 0.08), 0 4px 12px -2px rgba(26, 28, 36, 0.03)`. A trace of tinted indigo warmth within the shadow grounds floating operational elements.
- **Level 3 (Modal Sheets & Empathic Overlays)**: Deep ambient scrim paired with soft blurred backdrops (`backdrop-filter: blur(12px)`) to keep the conversational context visible yet dreamily out of focus.

## Shapes

The form language is organic, protective, and human. 

- **Primary Corner Radius**: `24dp` (1.5rem) on conversational cards, mood selectors, and sheets. This matches modern Android gesture ergonomics and eliminates sharp corners.
- **Interactive Elements**: Full pill geometry (`9999px`) on floating audio buttons, chips, and quick-reply reaction bars.
- **Nesting Consistency**: Inner sub-elements (such as image attachments within an AI message container) follow concentric curvature, scaling down to `16dp` or `12dp` to prevent visual tension.

## Components

### Buttons
- **Primary**: Filled Electric Indigo (`#4F46E5`), text `#FFFFFF`, fully rounded pill (`rounded-full`), height `52dp`, padding `0 24dp`. Interactive states transition to `#4338CA` with subtle spring scale feedback (0.98x).
- **Secondary / Soft**: Soft Iris background (`#EEF2FF`), text `#4F46E5`, zero border, same pill silhouette.
- **Ghost / Tertiary**: Transparent fill, muted text `#767680`, active highlight in warm ivory tint.

### Conversation Bubbles
- **User Bubble**: Background `#4F46E5`, text `#FFFFFF`, rounded `24dp` with trailing bottom corner slightly reduced to `8dp` to indicate origin.
- **Lumière (AI) Bubble**: Background `#FFFFFF`, border `1px solid #E2E5EE`, text `#1A1C24`, rounded `24dp` with leading bottom corner softened. Accompanied by a 2dp glowing Sunrise Peach accent line or avatar beacon.

### Chips & Mood Selectors
- Compact pills (`36dp` height). Unselected state sits in `#FFFFFF` with a `1px solid #E2E5EE` border and `#767680` text. Selected state morphs into a warm sunrise tint (`#FFEDD5`) with `#1A1C24` text and an optional `#FDBA74` subtle edge glow.

### Input Dock
- Floating capsule resting above the bottom navigation bar. Background `#FFFFFF` with Level 2 elevation shadow and `1px solid #E2E5EE`.
- Integrated microphone icon button anchored with a warm sunrise micro-gradient when listening.

### Cards
- Surfaces rendered in `#FFFFFF`, `24dp` corner radius, `20dp` internal padding. Dividers within cards are strictly avoided; spatial separation is achieved purely via `16dp` vertical gap steps.

### Voice & Resonance Wave (Companion-Specific)
- Audio visualization bars and rings use smooth cubic beziers modulating between Electric Indigo (`#4F46E5`) and Sunrise Peach (`#FDBA74`) at 30% opacity overlays, pulsing in a calm breathing cadence (approx. 0.25Hz).
