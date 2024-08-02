//
//  Colors.swift
//  iosApp
//
//  Created by Riparia on 02.08.24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared

extension Color {
    init(hex: Int64, alpha: Double = 1) {
        self.init(
            .sRGB,
            red: Double((hex >> 16) & 0xff) / 255,
            green: Double((hex >> 08) & 0xff) / 255,
            blue: Double((hex >> 00) & 0xff) / 255,
            opacity: alpha
        )
    }
    
    private static let colors = Colors()
    static let lightBlue = Color(hex: colors.LightBlue)
    static let lightBlueGrey = Color(hex: colors.LightBlueGrey)
    static let accentViolet = Color(hex: colors.AccentViolet)
    static let textBlack = Color(hex: colors.TextBlack)
    static let darkGrey = Color(hex: colors.DarkGrey)
    
    static let primary = Color(light: Color.accentViolet, dark: .accentViolet)
    static let background = Color(light: Color.lightBlueGrey, dark: .darkGrey)
    static let onPrimary = Color(light: Color.white, dark: .white)
    static let onBackground = Color(light: Color.textBlack, dark: .white)
    static let surface = Color(light: Color.white, dark: .darkGrey)
    static let onSurface = Color(light: Color.textBlack, dark: .white)
}

private extension Color {
    init (light: Self, dark: Self) {
        self.init(uiColor: UIColor(light: UIColor(light), dark: UIColor(dark)))
    }
}

private extension UIColor {
    convenience init(light: UIColor, dark: UIColor) {
        self.init { traits in
            switch traits.userInterfaceStyle {
            case .light, .unspecified:
                return light
            case .dark:
                return dark
            @unknown default:
                return light
            }
        }
    }
}
